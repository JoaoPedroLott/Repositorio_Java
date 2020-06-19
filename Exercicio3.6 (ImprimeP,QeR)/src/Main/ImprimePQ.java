package Main;

import java.util.concurrent.Semaphore;

public class ImprimePQ extends Thread{

	private Semaphore s1;
	private char ch;

	public ImprimePQ(Semaphore s1, char ch) {
		this.s1 = s1;
		this.ch = ch;
	}

	@Override
	public void run() {
		// Cria contador
		int cont = 0;
		
		while (true) {
			//Imprime e libera a permissao para R imprimir
			try {
				System.out.println(ch + "(" + (++cont) + ")");
				s1.release();
				Thread.sleep(100);
			} catch (InterruptedException e) { }
		}
	}
}