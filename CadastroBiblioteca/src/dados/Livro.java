package dados;

import java.util.GregorianCalendar;

public class Livro {
	private int codigo;
	private String titulo;
	private String autor;
	private GregorianCalendar dtRegistro;
	
	public Livro(int codigo, String titulo, String autor, GregorianCalendar dtRegistro) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
		this.dtRegistro = dtRegistro;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public GregorianCalendar getDtRegistro() {
		return dtRegistro;
	}

	public void setDtRegistro(GregorianCalendar dtRegistro) {
		this.dtRegistro = dtRegistro;
	}

	@Override
	public String toString() {
		return "Livro [codigo=" + codigo + ", titulo=" + titulo + ", autor=" + autor + ", dtRegistro=" + dtRegistro
				+ "]";
	}
}
