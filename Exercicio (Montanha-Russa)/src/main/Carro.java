package main;

public class Carro extends Thread {

	private int tamanho;
	private int lotacao;
	private int estado = 1;

	public Carro(int maxSize) {
		this.tamanho = maxSize;
	}

	public synchronized void carregar() {
		this.estado = 1;
		if (lotacao < tamanho) {
			lotacao++;
			System.out.println(
					"Carro " + this.getName() + "está carregando passageiros e tem " + this.lotacao + " passageiros!");
		}
		this.notifyAll();
	}

	public synchronized void andar() {
		if (lotacao == tamanho) {
			this.estado = 2;
			System.out.println("Carro " + this.getName() + " partiu com " + this.lotacao + " passageiros!");
			this.estado = 3;
		}
		this.notifyAll();
	}

	public synchronized void descarregar() {
		this.estado = 3;
		if (lotacao > 0) {
			lotacao--;
			this.notifyAll();
		}
		if (lotacao == 0) {
			this.estado = 1;
		}
		System.out.println("Carro está descarregando e tem " + lotacao + " passageiros!");
		this.notifyAll();
	}

	public synchronized int getEstado() {
		return this.estado;
	}
}