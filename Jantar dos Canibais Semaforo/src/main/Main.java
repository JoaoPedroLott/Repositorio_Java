package main;

import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
	
		Panela panela = new Panela();
		
		Produtor produtor = new Produtor(panela);
		new Thread(produtor).start();
        Consumidor consumidor = new Consumidor(panela);
        new Thread(consumidor).start();
	}
}

//--------------------------------------------------------------------------------------------------------------
class Produtor implements Runnable {
	private final Panela p;

	public Produtor(Panela initb) {
		p = initb;
	}

	public void run() {
		int item;
		Random r = new Random();

		while (true) {
			item = r.nextInt(10) + 1;
			try {
				p.colocaPorcao(item);
			} catch (InterruptedException e) {
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

//--------------------------------------------------------------------------------------------------------------
class Consumidor implements Runnable {
	private final Panela p;

	public Consumidor(Panela initb) {
		p = initb;
	}

	public void run() {
		int item;
		while (true) {
			try {
				item = p.pegaPorcao();
				
				System.out.println("Canibal consumiu: " + item);
			} catch (InterruptedException e) {
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}