package main;

import java.io.Serializable;

public class Cliente implements Serializable {

	private static final long serialVersionUID = -184008917776802895L;

	private String nome;
	private double debito;

	public Cliente() {
	}

	public Cliente(String nome) {
		setNome(nome);
		setDebito(0.0);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

	public double getDebito() {
		return debito;
	}

	public void setDebito(double debito) {
		this.debito = debito;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Cliente other = (Cliente) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
