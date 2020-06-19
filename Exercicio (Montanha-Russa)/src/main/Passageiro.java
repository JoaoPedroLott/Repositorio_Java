package main;

public class Passageiro extends Thread {

	private Carro carro;
	private int estado;

	public Passageiro(Carro carro) {
		this.carro = carro;
		this.estado = 1;
	}

	public void embarcar() {
		synchronized (carro) {
			while (carro.getEstado() == 2 || carro.getEstado() == 3 || this.estado == 2) {
				try {
					carro.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (carro.getEstado() == 1) {
				carro.carregar();
				this.estado = 2;
			}
			System.out.println("Passageiro " + this.getId() + " embarcou no carro!");
			carro.andar();
			carro.notifyAll();
		}
	}

	public void desembarcar() {
		synchronized (carro) {
			while (carro.getEstado() != 3) {
				try {
					carro.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (carro.getEstado() == 3 && this.estado == 2) {
				carro.descarregar();
				this.estado = 1;
			}
			System.out.println("Passageiro " + this.getId() + " desembarcou do carro!");
			carro.notifyAll();
		}
	}

	@Override
	public void run() {
		super.run();
		while (true) {
			embarcar();
			desembarcar();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
