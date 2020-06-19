package main;

public class Cliente extends Thread {

	private Barbeiro brb = null;
	private int id = 0;

	public Cliente(int id, Barbeiro bd) {
		this.id = id;
		this.brb = bd;
	}

	@Override
	public void run() {
		if (brb.entraBarbearia(this.id)) {
			System.out.println("Cliente " + id + " cortando o cabelo");
			brb.saiBarbearia(this.id);
		}
	}
}
