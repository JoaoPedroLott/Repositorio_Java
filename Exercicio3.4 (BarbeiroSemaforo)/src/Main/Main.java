package Main;

public class Main {

	public static void main(String[] args) {

		Recursos r = new Recursos();
		for (int i = 1; i <= 10; i++)
			new Cliente(i, r).start();

		for (int i = 1; i <= 4; i++)
			new Barbeiro(i, r).start();
	}
}
