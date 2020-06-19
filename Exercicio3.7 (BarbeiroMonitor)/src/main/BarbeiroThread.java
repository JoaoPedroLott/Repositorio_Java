package main;

public class BarbeiroThread extends Thread {

	private Barbeiro brb = null;
	
	public BarbeiroThread(Barbeiro brb) {
		this.brb = brb;
	}
	
	@Override
	public void run() {
		while(true) {
			brb.inicioCorte();
			
			System.out.println("Barbeiro cortando cabelo");
			try {Thread.sleep(2000);} catch (InterruptedException e) {}
			
			brb.fimcorte();
		}
	}

}
