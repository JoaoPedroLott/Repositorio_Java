package Main;

public class Cliente extends Thread{
	
	private int id;
	private Recursos r;
	
	public Cliente(int id, Recursos r) {
		this.id = id;
		this.r = r;
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("Cliente " + id + " aguardando o barbeiro para corte");
				Thread.sleep((int)(Math.random()*100));
				r.corteDeCabelo();
				System.out.println("Cliente " + id + " aguardando fim do corte");
				Thread.sleep((int)(Math.random()*100));
				r.corteDeCabeloFim();
				System.out.println("Cliente " + id + " teve o seu corte terminado");
				Thread.sleep((int)(Math.random()*100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
