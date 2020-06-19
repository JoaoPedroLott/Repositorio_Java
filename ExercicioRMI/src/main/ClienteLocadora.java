package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.RMISecurityManager;

public class ClienteLocadora {

	public static void main(String[] args) {
		System.setProperty("java.security.policy", "client.policy");
		if (System.getSecurityManager() == null)
			System.setSecurityManager(new RMISecurityManager());

		BufferedReader stdinp = new BufferedReader(new InputStreamReader(System.in));

		try {
			int opcao = 0;
			while (opcao != 99) {
				System.out.println("O que você deseja fazer:");
				System.out.println("1 - Consultar débito");
				System.out.println("2 - Atualizar débito");
				System.out.println("3 - Adicionar cliente");
				System.out.println("4 - Remover cliente");
				System.out.println("99 - Sair");
				System.out.println("Digite a opção desejada:");

				opcao = Integer.parseInt(stdinp.readLine());

				switch (opcao) {
				case 1:
					Locadora.consultarDebito();
					break;
				case 2:
					Locadora.atualizarDebito();
					break;
				case 3:
					Locadora.adicionarCliente();
					break;
				case 4:
					Locadora.removerCliente();
					break;

				case 99:
					break;

				default:
					System.out.println("Opção inválida!!");
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
