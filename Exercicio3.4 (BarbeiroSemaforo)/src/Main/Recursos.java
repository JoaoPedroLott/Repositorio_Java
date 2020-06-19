package Main;

import java.util.concurrent.Semaphore;

public class Recursos {

	private int clienteAtivos = 0;
	private int clienteEspera = 0;
	private int barbeiroAtivos = 0;
	private int barbeiroEspera = 0;

	// Semáforos
	private Semaphore cliente = new Semaphore(0);
	private Semaphore barbeiro = new Semaphore(0);
	private Semaphore mutex = new Semaphore(1);

	public void corteDeCabelo() throws InterruptedException {
		// Pega permissão do semáforo binario
		mutex.acquire();
		// Verifica se o barbeiro esta dormindo
		if (barbeiroEspera > 0) {
			// Cliente em espera incrementa
			clienteEspera++;
			// libera o semaforo
			mutex.release();

			cliente.acquire();
			mutex.acquire();
			clienteEspera--;
		}
		// Se barbeiro nao esta dormindo
		// cliente em trabalho (cortando cabelo) incrementa
		clienteAtivos++;
		// libera a permissao
		mutex.release();
	}

	public void corteDeCabeloFim() throws InterruptedException {
		// pega permissao
		mutex.acquire();
		clienteAtivos--;
		// Se nao houver clientes e tiver barbeiros prontos para cortar
		// libera o barbeiro para dormir
		if (clienteEspera != 0 && barbeiroEspera > 0)
			barbeiro.release();
		// libera semaforo
		mutex.release();
	}

	public void barbeiro() throws InterruptedException {
		// Pega permissao
		mutex.acquire();
		if (clienteEspera > 0) {
			barbeiroEspera++;
			mutex.release();
			barbeiro.acquire();
			mutex.acquire();
			barbeiroEspera--;
		}
		barbeiroAtivos++;
		// Libera permissao
		mutex.release();
	}

	public void barbeiroFim() throws InterruptedException {
		// pega permissao
		mutex.acquire();
		barbeiroAtivos--;
		// Se tiver clientes em espera, libera os clientes
		if (clienteEspera > 0)
			for (int i = 0; i < clienteEspera; i++)
				cliente.release();
		// Senao
		else if (clienteEspera != 0 && barbeiroEspera > 0)
			barbeiro.release();
		// libera permissao
		mutex.release();
	}
}
