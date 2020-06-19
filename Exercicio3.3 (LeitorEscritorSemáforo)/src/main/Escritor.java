package main;

public class Escritor extends Thread {

	private int idEscritor;
	private LeitorEscritor le;
	
	public Escritor(int idEscritor, LeitorEscritor le) {
		super();
		this.idEscritor = idEscritor;
		this.le = le;
	}

	public void run() {
		try {
			for (int i = 0; i <= 110; i++) {
				le.iniciarEscrita();
				System.out.println("O escritor " + idEscritor + " começou a escrever.");
				sleep(20);
				System.out.println("O escritor " + idEscritor + " terminou de escrever.");
				le.terminarEscrita();
				sleep(1700);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
