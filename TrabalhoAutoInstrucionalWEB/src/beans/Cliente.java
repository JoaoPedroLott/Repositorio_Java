package beans;

public class Cliente {

	private int codigoCliente;
	private String nomeCliente;
	private String emailCliente;
	private String senhaCliente;
	
	public Cliente() {
		
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getSenhaCliente() {
		return senhaCliente;
	}

	public void setSenhaCliente(String senhaCliente) {
		this.senhaCliente = senhaCliente;
	}

	@Override
	public String toString() {
		return "Cliente [codigoCliente=" + codigoCliente + ", nomeCliente=" + nomeCliente + ", emailCliente="
				+ emailCliente + ", senhaCliente=" + senhaCliente + "]";
	}
}
