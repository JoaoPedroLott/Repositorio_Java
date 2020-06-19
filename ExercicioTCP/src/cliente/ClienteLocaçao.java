package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;

public class ClienteLocaçao {

	private static Socket s1;
	private static Socket s2;
	private static HashMap<String, Cliente> clientes = new HashMap<String, Cliente>();

	public static void main(String[] args) throws Exception {

		s1 = new Socket("127.0.0.1", 2018);
		s2 = new Socket("127.0.0.1", 2018);

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						String[] msg = new BufferedReader(new InputStreamReader(s2.getInputStream())).readLine()
								.split("&");
						Cliente client = clientes.get(msg[0]);
						if (msg[1].equals("search")) {
							PrintWriter out = new PrintWriter(s2.getOutputStream());
							out.println(client.getDebito() + "");
							out.flush();
						} else {
							client.setDebito(Integer.parseInt(msg[2]));
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

		while (true) {
			System.out.println("Menu");
			System.out.println("1- Debito.");
			System.out.println("2- Atualizar Debito.");
			System.out.println("3- Cadastrar cliente.");
			System.out.println("4- Excluir cliente.");
			System.out.println("Opção:");

			int opcao = 0;

			while (true) {
				try {
					opcao = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
					if (opcao > 0)
						break;
				} catch (Exception e) {
				}
				System.out.println("Numero errado.");
			}

			switch (opcao) {
			case 1:
				realizaDebito();
				break;
			case 2:
				atualizarDebito();
				break;
			case 3:
				adicionarCliente();
				break;
			case 4:
				excluirCliente();
				break;
			default:
				return;
			}
		}
	}

	private static void adicionarCliente() throws Exception {

		PrintWriter out = new PrintWriter(s1.getOutputStream());

		out.println("3");
		out.flush();

		System.out.println("Informe o identificador do cliente: ");
		String id = new BufferedReader(new InputStreamReader(System.in)).readLine();

		System.out.println("Informe o Nome do Cliente: ");
		String nome = new BufferedReader(new InputStreamReader(System.in)).readLine();
		out = new PrintWriter(s1.getOutputStream());
		out.println(id);
		out.flush();

		if ("cadastrado".equals(new BufferedReader(new InputStreamReader(s1.getInputStream())).readLine())) {
			clientes.put(id, new Cliente(nome, 0));
			System.out.println("Cliente Cadastrado com Sucesso!!");
		} else
			System.out.println("Este cliente já está cadastrado.");
	}

	private static void excluirCliente() throws Exception {

		PrintWriter out = new PrintWriter(s1.getOutputStream());
		out.println("4");
		out.flush();

		System.out.println("Informe o identificador do cliente: ");
		String number = new BufferedReader(new InputStreamReader(System.in)).readLine();
		out = new PrintWriter(s1.getOutputStream());
		out.println(number);
		out.flush();

		if ("removido".equals(new BufferedReader(new InputStreamReader(s1.getInputStream())).readLine()))
			System.out.println("Cliente removido com sucesso!!");
		else
			System.out.println("Cliente não encontrado para o ID informado.");
	}

	private static void realizaDebito() throws IOException {

		PrintWriter out = new PrintWriter(s1.getOutputStream());
		out.println("1");
		out.flush();

		System.out.println("Informe o identificador do cliente: ");
		String numero = new BufferedReader(new InputStreamReader(System.in)).readLine();
		out = new PrintWriter(s1.getOutputStream());
		out.println(numero);
		out.flush();

		String debito = new BufferedReader(new InputStreamReader(s1.getInputStream())).readLine();
		if ("".equals(debito))
			System.out.println("Cliente não encontrado para o ID informado.");
		else
			System.out.println("Operação Relizada com Sucesso.  O debito é de R$" + debito);
	}

	private static void atualizarDebito() throws Exception {

		PrintWriter out = new PrintWriter(s1.getOutputStream());
		out.println("2");
		out.flush();

		System.out.println("Informe o identificador do cliente: ");
		String numero = new BufferedReader(new InputStreamReader(System.in)).readLine();
		out = new PrintWriter(s1.getOutputStream());
		out.println(numero);
		out.flush();

		System.out.println("Informe o novo valor: ");
		String debito = new BufferedReader(new InputStreamReader(System.in)).readLine();
		out = new PrintWriter(s1.getOutputStream());
		out.println(debito);
		out.flush();

		if ("atualizado".equals(new BufferedReader(new InputStreamReader(s1.getInputStream())).readLine())) {
			System.out.println("Debito Realizado com Sucesso.");
		} else
			System.out.println("Cliente não encontrado para o ID informado.");
	}

}
