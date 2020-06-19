package cliente;

public class Cliente {

	private String nome;
	private int debito;
	
	public Cliente(String nome, int debito){
		this.nome = nome;
		this.debito = debito;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getDebito() {
		return debito;
	}

	public void setDebito(int debito) {
		this.debito = debito;
	}	
}
