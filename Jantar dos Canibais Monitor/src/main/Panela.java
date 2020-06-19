package main;

public class Panela {

	private int porcoes = 0;

	// metodo que controla o cozinheiro enchendo panela
	public synchronized void colocaPorcao(int qtd) throws InterruptedException {

		while (porcoes != 0){
			this.wait();
		}
		System.out.println("O cozinheiro acordou.");
		porcoes += qtd;
		System.out.println("O cozinheiro colocou " + porcoes + " porções na panela.");
		System.out.println("O cozinheiro está dormindo.");
		notifyAll();
	}

	// metodo que controla os canibais comendo
	public synchronized int pegaPorcao() throws InterruptedException {

		while (porcoes == 0){
			this.wait();
		}
		porcoes--;
		notifyAll();
		return porcoes;
	}
}
