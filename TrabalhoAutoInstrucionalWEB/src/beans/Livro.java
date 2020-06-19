package beans;

public class Livro {

	private int codigoLivro;
	private String titulo;
	private double preco;
	private int ano;
	private int paginas;
	private int idAssunto;
	
	public Livro() {
		
	}

	public int getCodigoLivro() {
		return codigoLivro;
	}

	public void setCodigoLivro(int codigoLivro) {
		this.codigoLivro = codigoLivro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public int getIdAssunto() {
		return idAssunto;
	}

	public void setIdAssunto(int idAssunto) {
		this.idAssunto = idAssunto;
	}

	@Override
	public String toString() {
		return "Livro [codigoLivro=" + codigoLivro + ", titulo=" + titulo + ", preco=" + preco + ", ano=" + ano
				+ ", paginas=" + paginas + ", idAssunto=" + idAssunto + "]";
	}
}
