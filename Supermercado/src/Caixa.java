import java.util.ArrayList;

public class Caixa extends Thread {
	// Propriedades da classe
	private int identificador = 0;
	private ArrayList<Cliente> fila = new ArrayList<Cliente>();

	// Método construtor cheio da classe
	public Caixa(int identificador) {
		super();
		this.identificador = identificador;
	}
	
	// Métodos get/set da classe
	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	
	// Métodos da classe
	public void colocarClienteNaFila(Cliente objCliente) {
		fila.add(objCliente);
	}
	
	public synchronized Cliente retirarClienteDaFila() {
		Cliente retorno = null;
		
		try {retorno = fila.remove(fila.size() - 1);}
		catch(Exception erro) {}
		
		return retorno;
	}
	
	public int getQuantidadeClientesNaFila() {
		return fila.size();
	}
	
	// Método de execução paralela da classe
	public void run() {
		while (true) {
			if (fila.size() > 0) {
				// Atender a própria fila
				try {
					sleep(fila.get(0).getTempoAtendimento() * 1000);
				} catch (Exception e) {}
				
				fila.remove(0);
			} else {
				// Roubar um cliente de algum outro caixa
				int maisClientes = 0;
				int numeroDoCaixa = 0;
				
for (Caixa objCaixa : Supermercado.getColecao()) {
	if (objCaixa.getIdentificador() != identificador) {
		if (maisClientes < objCaixa.getQuantidadeClientesNaFila()) {
			maisClientes = objCaixa.getQuantidadeClientesNaFila();
			numeroDoCaixa = objCaixa.getIdentificador();
		}
	}
}
				
				colocarClienteNaFila(Supermercado.getColecao()
									 .get(numeroDoCaixa)
									 .retirarClienteDaFila());
			}
		}
	}

}