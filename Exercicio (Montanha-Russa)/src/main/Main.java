package main;

public class Main {
	
	public static void main(String[] args) {

		int numPassengers = 5;

		Carro carro = new Carro(5);

		for (int i = 0; i < numPassengers; i++) {
			new Passageiro(carro).start();
		}
	}
}
