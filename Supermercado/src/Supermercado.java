import java.util.LinkedList;

public class Supermercado {
	// Propriedades da classe
	private static LinkedList<Caixa> colecao =
										new LinkedList<Caixa>();
	
	// Métodos da classe
	public static void adicionarCaixa(int identificador) {
		colecao.add(new Caixa(identificador));
	}
	
	public static void removerCaixa() {
		if (colecao.size() > 0) {
			colecao.remove(0);
		}
	}
	
	public static LinkedList<Caixa> getColecao() {
		return colecao;
	}
}