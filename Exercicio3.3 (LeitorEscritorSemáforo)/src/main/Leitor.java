package main;

public class Leitor extends Thread {

	private int idLeitor;
	private LeitorEscritor le;
	
	public Leitor(LeitorEscritor le, int idLeitor) {
		super();
		this.idLeitor = idLeitor;
		this.le = le;
	}
	
	public void run() {
		try {
			for(int i = 0; i <= 110; i++) {
				le.iniciarLeitura();
				System.out.println("O leitor "+ idLeitor +" começou a ler.");
				sleep(20);
				System.out.println("O leitor"+ idLeitor +" terminou de ler.");
				le.terminarLeitura();
				sleep(20);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
