package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;

public class Locadora {

	private static ServicoLocadora r;

	private static ServicoLocadora getLocadoraService() {
		try {
			if (r == null)
				r = (ServicoLocadora) Naming.lookup("rmi://localhost:1099/LocadoraServer");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return r;
	}

	public static void consultarDebito() {
		System.out.println("Opção escolhida: Consultar Débito.");
		ServicoLocadora s = getLocadoraService();
		BufferedReader stdinp = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("Digite o nome do cliente:");
			String nome = stdinp.readLine();

			double debito = s.consultarDebito(nome);
			if (debito == -1) {
				System.out.println("O cliente " + nome + " não existe.");
			} else {
				System.out.println("O débito do cliente " + nome + " é " + debito + ".");
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void atualizarDebito() {
		System.out.println("Opção escolhida: Atualizar Débito.");
		ServicoLocadora s = getLocadoraService();
		BufferedReader stdinp = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("Digite o nome do cliente:");
			String nome = stdinp.readLine();

			System.out.println("Digite o novo débito do cliente:");
			double novoDebito = Double.parseDouble(stdinp.readLine());

			boolean feito = s.atualizarDebito(nome, novoDebito);
			if (feito) {
				System.out.println("Débito atualizado.");
			} else {
				System.out.println("Débito não atualizado. Cliente não encontrado.");
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void adicionarCliente() {
		System.out.println("Opção escolhida: Adicionar Cliente.");
		ServicoLocadora s = getLocadoraService();
		BufferedReader stdinp = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("Digite o nome do cliente:");
			String nome = stdinp.readLine();

			boolean feito = s.adicionarCliente(nome);
			if (feito) {
				System.out.println("Cliente adicionado.");
			} else {
				System.out.println("Cliente já existe.");
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void removerCliente() {
		System.out.println("Opção escolhida: Remover Cliente.");
		ServicoLocadora s = getLocadoraService();
		BufferedReader stdinp = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("Digite o número do cliente:");
			String nome = stdinp.readLine();

			boolean feito = s.excluirCliente(nome);
			if (feito) {
				System.out.println("Cliente excluído.");
			} else {
				System.out.println("Cliente não encontrado.");
			}

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
