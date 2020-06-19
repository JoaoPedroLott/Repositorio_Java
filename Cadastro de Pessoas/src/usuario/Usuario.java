package usuario;

import java.sql.Date;
import java.sql.SQLException;

import dados.Pessoa;

import utilitarios.Console;
import utilitarios.LtpUtil;

import banco.Banco;

public class Usuario {

	public static void main(String[] args) {
		try {
			Banco.abrirConexao();
			menu();
			Banco.fecharConexao();
			System.out.println("Final dos testes.");
			System.exit(0);
		} catch (SQLException e) {
			System.out.println("Falha conexão - " + e.getMessage());
			System.exit(1);
		}

	}

	private static void menu() {
		int opcao=0;
		do {
			System.out.println("MENU PESSOAS");
			System.out.println("1-INCLUIR");
			System.out.println("2-ALTERAR");
			System.out.println("3-EXCLUIR");
			System.out.println("4-CONSULTAR PELO CÓDIGO");
			System.out.println("5-CONSULTAR PELO NOME");
			System.out.println("6-CONSULTAR PELO MES DE NASCIMENTO");
			System.out.println("0-SAIR");
			opcao = Console.readInt("Opção: ");
			switch (opcao) {
				case 1:
					incluir();
					break;
				case 2:
					alterar();
					break;
				case 3:
					excluir();
					break;
				case 4:
					consPessoaCodigo();
					break;
				case 5:
					consPessoaNome();
					break;
				case 6:
					consPessoaMesNasc();
					break;
				case 0:
					break;
				default:
					System.out.println("Opção inválida.");
					break;
			}
			
		} while (opcao!=0);
	
		
	}

	private static void incluir() {
		System.out.println("\nIncluir Pessoa\n");
		String nome = "";
		String telefone = "";
		Date nascimento = new Date(System.currentTimeMillis());
		String email = "";
		while (true) {
			nome = Console.readLine("Nome: ").trim();
			if (nome.isEmpty()) System.out.println("Falta o nome.");
			else break;
		}
		telefone = Console.readLine("Telefone: ");
		while (true) {
			String nascTexto = Console.readLine("Nasc. dd/mm/aaaa : ");
			if (LtpUtil.validarData(nascTexto, nascimento) && 
				nascimento.before(new Date(System.currentTimeMillis()))	) {
				break;
			} else System.out.println("Data nasc. inválida.");
		}
		while (true) {
			email = Console.readLine("Email: ");
			if (LtpUtil.validarEmail(email)) break;
			else System.out.println("Email inválido.");
		}
		
		try {
			Banco.incluirPessoa(new Pessoa(0, nome, telefone, nascimento, email));
			System.out.println("Pessoa Cadastrada.");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "\n");
		}
	}

	private static void alterar() {
		System.out.println("\nAlterar Pessoa\n");
		String nome = "";
		String telefone = "";
		Date nascimento = new Date(System.currentTimeMillis());
		String email = "";
		int codigo = 0;
		try {
			codigo = Console.readInt("Código: ");
			Pessoa objPessoa = Banco.consPessoaCodigo(codigo);
			System.out.println(objPessoa.toString());
			String alteraNome = Console.readLine("Alterar o nome? s/n : ");
			if (alteraNome.equalsIgnoreCase("s")) {
				while (true) {
					nome = Console.readLine("Nome: ").trim();
					if (nome.isEmpty()) System.out.println("Falta o nome.");
					else break;
				}
				objPessoa.setNome(nome);
			}
			String alteraTelef = Console.readLine("Alterar o telefone? s/n : ");
			if (alteraTelef.equalsIgnoreCase("s")) {
				telefone = Console.readLine("Telefone: ");
				objPessoa.setTelefone(telefone);
			}
			String alteraNasc = Console.readLine("Alterar o nascimento? s/n : ");
			if (alteraNasc.equalsIgnoreCase("s")) {
				while (true) {
					String nascTexto = Console.readLine("Nasc. dd/mm/aaaa : ");
					if (LtpUtil.validarData(nascTexto, nascimento) && 
						nascimento.before(new Date(System.currentTimeMillis()))	) {
						break;
					} else System.out.println("Data nasc. inválida.");
				}
				objPessoa.setNascimento(nascimento);
			}
			String alteraEmail = Console.readLine("Alterar o email? s/n : ");
			if (alteraEmail.equalsIgnoreCase("s")) {
				while (true) {
					email = Console.readLine("Email: ");
					if (LtpUtil.validarEmail(email)) break;
					else System.out.println("Email inválido.");
				}
				objPessoa.setEmail(email);
			}
			Banco.alterarPessoa(objPessoa);
			System.out.println("Pessoa alterada.");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "\n");
		}
		
	}

	private static void excluir() {
		// TODO Auto-generated method stub
		
	}

	private static void consPessoaCodigo() {
		System.out.println("\nConsultar Pessoa pelo Código\n");
		try {
			int codigo = Console.readInt("Código: ");
			Pessoa objPessoa = Banco.consPessoaCodigo(codigo);
			System.out.println(objPessoa.toString());
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "\n");
		}
		
	}

	private static void consPessoaNome() {
		// TODO Auto-generated method stub
		
	}

	private static void consPessoaMesNasc() {
		// TODO Auto-generated method stub
		
	}

}
