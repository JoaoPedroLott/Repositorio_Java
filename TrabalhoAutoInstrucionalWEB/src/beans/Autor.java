package beans;

public class Autor {

	private int codigoAutor;
	private String nomeAutor;
	
	public Autor() {
		
	}

	public int getCodigoAutor() {
		return codigoAutor;
	}

	public void setCodigoAutor(int codigoAutor) {
		this.codigoAutor = codigoAutor;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	@Override
	public String toString() {
		return "Autor [codigoAutor=" + codigoAutor + ", nomeAutor=" + nomeAutor + "]";
	}
}
