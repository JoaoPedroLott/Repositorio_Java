package Main;

import java.util.concurrent.Semaphore;

public class Main {
	
	public static void main(String[] args) {
		Semaphore s1 = new Semaphore(0);
		
		ImprimeR r = new ImprimeR(s1);
		ImprimePQ p = new ImprimePQ(s1, 'P');
		ImprimePQ q = new ImprimePQ(s1, 'Q');
		
		r.start();
		p.start();
		q.start();
	}
}