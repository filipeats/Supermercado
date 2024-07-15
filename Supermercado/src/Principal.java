public class Principal {
	public static void main(String[] args) {
		new CriadorCliente().start();
		
		Supermercado.adicionarCaixa(0);
		Supermercado.adicionarCaixa(1);
		Supermercado.adicionarCaixa(2);
		Supermercado.adicionarCaixa(3);
		
		for (Caixa objCaixa : Supermercado.getColecao()) {
			objCaixa.start();
		}
		
		while (true) {
			for (Caixa objCaixa : Supermercado.getColecao()) {
				System.out.print(objCaixa.getIdentificador() + " ");
				for (int i = 0 ;
					 i < objCaixa.getQuantidadeClientesNaFila() ;
					 i++) {
					System.out.print("=");
				}
				System.out.println();
			}
			System.out.println();
			
			try {Thread.sleep(1000);} catch (Exception e) {}
		}
	}
}