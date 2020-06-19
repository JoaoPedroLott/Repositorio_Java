package main;

public class Barbearia {

	public static void main(String[] args) {
		
		Barbeiro brb = new Barbeiro(5);
		new BarbeiroThread(brb).start();
		
		for(int i = 1; i <= 20; i++) {
			new Cliente(i,brb).start();
			try {Thread.sleep(1000);} catch (InterruptedException e) {}
		}
	}
}
