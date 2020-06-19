package main;

import java.util.concurrent.Semaphore;

public class LeitorEscritor {

	private int numLeitores = 0;
	private int numEscritores = 0;
	private int numLeitorEspera = 0;
	private int numEscritorEspera = 0;

	private Semaphore leitor = new Semaphore(0);
	private Semaphore escritor = new Semaphore(0);
	private Semaphore mutex = new Semaphore(0);

	public void iniciarLeitura() throws InterruptedException {

		mutex.acquire();
		// Se tiver escritor trabalhando ou em espera,
		// leitores em espera incrementa
		if (numEscritores > 0 || numEscritorEspera > 0) {
			++numLeitorEspera;
			mutex.release();
			leitor.acquire();
			mutex.acquire();
			--numLeitorEspera;
		}
		++numLeitores;
		mutex.release();
	}

	public void terminarLeitura() throws InterruptedException {

		mutex.acquire();
		--numLeitores;

		if (numLeitores == 0 && numEscritorEspera > 0) {
			escritor.release();
		}
		mutex.release();
	}

	public void iniciarEscrita() throws InterruptedException {

		mutex.acquire();

		if (numLeitores > 0 || numLeitorEspera > 0 || numEscritores > 0 || numEscritorEspera > 0) {
			++numEscritorEspera;
			mutex.release();
			escritor.acquire();
			mutex.acquire();
			--numEscritorEspera;
		}
		++numEscritores;
		mutex.release();
	}

	public void terminarEscrita() throws InterruptedException {

		mutex.acquire();
		--numEscritores;

		if (numLeitorEspera > 0) {
			for (int i = 0; i == numEscritorEspera; i++)
				;
			{
				leitor.release();
			}
		} else if (numEscritorEspera > 0) {
			escritor.release();
		}
		mutex.release();
	}

public static void main(String[] args) throws InterruptedException {
		
		LeitorEscritor le = new LeitorEscritor();
		
		Leitor reader = new Leitor(le,1);
		reader.start();
		
		Leitor reader1 = new Leitor(le,2);
		reader1.start();
		
		Leitor reader2 = new Leitor(le,3);
		reader2.start();
		
		Leitor reader3 = new Leitor(le,4);
		reader3.start();
		
		Leitor reader4 = new Leitor(le,5);
		reader4.start();
		
		Leitor reader5 = new Leitor(le,6);
		reader5.start();
		
		Leitor reader6 = new Leitor(le,7);
		reader6.start();

		Leitor reader7 = new Leitor(le,8);
		reader7.start();
		
		Leitor reader8 = new Leitor(le,9);
		reader8.start();
		
		Leitor reader9 = new Leitor(le,10);
		reader9.start();
		
		Leitor reader10 = new Leitor(le,11);
		reader10.start();
		
		Escritor writer = new Escritor(1,le);
		writer.start();
		
		Escritor writer1 = new Escritor(2,le);
		writer1.start();
		
		Escritor writer2 = new Escritor(3,le);
		writer2.start();
	}
}
