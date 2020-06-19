package Main;

import java.util.concurrent.Semaphore;

public class ImprimeR  extends Thread{
	
	// Declara o semáforo
	private Semaphore s1;

	public ImprimeR(Semaphore s1) {
		this.s1 = s1;
	}

	@Override
	public void run() {
		// Cria um contador para o numero de R
		int cont = 0;
		
		while (true) {
			// Verificar se existe permissao
			try {
				// Pega a permissão
				s1.acquire();
				// Imprime R, mais o contador
				System.out.println("R(" + (++cont) + ")");
				Thread.sleep(50);
			} catch (InterruptedException e) {}	
		}
	}
}