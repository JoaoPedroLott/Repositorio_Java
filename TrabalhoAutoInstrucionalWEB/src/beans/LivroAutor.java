package beans;

public class LivroAutor {
	
	private int codigoLivroAutor;
	private int idLivro;
	private int idAutor;
	
	public LivroAutor() {
		
	}

	public int getCodigoLivroAutor() {
		return codigoLivroAutor;
	}

	public void setCodigoLivroAutor(int codigoLivroAutor) {
		this.codigoLivroAutor = codigoLivroAutor;
	}

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	@Override
	public String toString() {
		return "LivroAutor [codigoLivroAutor=" + codigoLivroAutor + ", idLivro=" + idLivro + ", idAutor=" + idAutor
				+ "]";
	}
}
