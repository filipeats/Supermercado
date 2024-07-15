public class Cliente {
	// Propriedades da classe
	private int tempoAtendimento = 0;
	
	// Método construtor vazio da classe
	public Cliente() {
		tempoAtendimento = (1 + ((int) (5 * Math.random()))); 
	}

	// Método get da classe
	public int getTempoAtendimento() {
		return tempoAtendimento;
	}
}