package Main;

public class Barbeiro extends Thread {

	private int id;
	private Recursos r;
	
	public Barbeiro(int id, Recursos r) {
		this.id = id;
		this.r = r;
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("Barbeiro " + id + " aguardando cliente");
				Thread.sleep((int)(Math.random()*100));
				r.barbeiro();
				System.out.println("Barbeiro " + id + " realizando corte");
				Thread.sleep((int)(Math.random()*100));
				r.barbeiroFim();
				System.out.println("Barbeiro " + id + " terminou o corte");
				Thread.sleep((int)(Math.random()*100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
