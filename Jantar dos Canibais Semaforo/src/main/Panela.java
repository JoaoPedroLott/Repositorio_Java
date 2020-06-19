package main;

import java.util.concurrent.Semaphore;

public class Panela {

	private int porcoes = 0;
	private boolean dormindo = true;

	private Semaphore cozinheiro = new Semaphore(0);
	private Semaphore canibal = new Semaphore(0);
	private Semaphore mutex = new Semaphore(1);

	// metodo que controla o cozinheiro enchendo panela
	public void colocaPorcao(int qtd) throws InterruptedException {
		cozinheiro.acquire();
		mutex.acquire();
		System.out.println("O cozinheiro acordou.");
		porcoes += qtd;
		for (int i = 0; i < qtd; i++)
			canibal.release();
		System.out.println("O cozinheiro colocou " + porcoes + " porções na panela.");
		System.out.println("O cozinheiro está dormindo.");
		dormindo = true;
		mutex.release();
	}

	// metodo que controla os canibais comendo
	public int pegaPorcao() throws InterruptedException {
		mutex.acquire();
		if (porcoes < 1 && dormindo) {
			dormindo = false;
			cozinheiro.release();
		}
		mutex.release();
		canibal.acquire();
		mutex.acquire();
		porcoes--;
		mutex.release();
		return porcoes;
	}
}
