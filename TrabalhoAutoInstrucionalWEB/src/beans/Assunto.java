package beans;

public class Assunto {

	private int codigoAssunto;
	private String nomeAssunto;
	
	public Assunto() {
		
	}

	public int getCodigoAssunto() {
		return codigoAssunto;
	}

	public void setCodigoAssunto(int codigoAssunto) {
		this.codigoAssunto = codigoAssunto;
	}

	public String getNomeAssunto() {
		return nomeAssunto;
	}

	public void setNomeAssunto(String nomeAssunto) {
		this.nomeAssunto = nomeAssunto;
	}

	@Override
	public String toString() {
		return "Assunto [codigoAssunto=" + codigoAssunto + ", nomeAssunto=" + nomeAssunto + "]";
	}
}
