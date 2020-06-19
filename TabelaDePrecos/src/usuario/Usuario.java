package usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dados.Produto;
import erro.ProdutoException;
import utilitarios.Console;
import banco.Banco;

public class Usuario {

	public static void main(String[] args) {
		try {
			Banco.abrirConexao();
			menu();
			Banco.fecharConexao();
			System.out.println("\nFinal da execu��o.");
			System.exit(0);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void menu() {
		int opcao = 0;
		do {
			System.out.println("\nTABELA DE PRE�OS");
			System.out.println("1-PESQUISA DE PRODUTO PELO C�DIGO");
			System.out.println("2-PESQUISA DE PRODUTOS PELO NOME");
			System.out.println("3-ESTAT�STICA DE PRODUTOS");
			System.out.println("4-INCLUIR PRODUTO");
			System.out.println("5-EXCLUIR PRODUTO");
			System.out.println("6-ALTERAR PRODUTO");
			System.out.println("0-SAIR");
			opcao = Console.readInt("Informe a op��o: ");
			switch (opcao) {
				case 1:
					pesqCodigo();
					break;
				case 2:
					pesqNome();
					break;
				case 3:
					estatistica();
					break;
				case 4:
					incluir();
					break;
				case 5:
					excluir();
					break;
				case 6:
					alterar();
					break;
				case 0 : break;	
				default:
					System.out.println("Op��o inv�lida.");
					break;
			}
		} while (opcao!=0);

		
	}

	private static void alterar() {
		System.out.println("\nAlterar Produto\n");
		boolean alterou = false;
		try {
			int codigo = Console.readInt("Informe o c�digo: ");
			Produto obj = Banco.pesqProdutoCodigo(codigo);
			System.out.println(obj.toString());
			String nome = Console.readLine("Informe o nome se quiser alterar: ").trim().toUpperCase();
			if (!nome.isEmpty()) {
				obj.setNome(nome);
				alterou = true;
			}
			double preco = Console.readDouble("Informe o pre�o se quiser alterar: ");
			if (preco > 0) {
				obj.setPreco(preco);
				alterou = true;
			}
			if (alterou) {
				Banco.alterarProduto(obj);
				System.out.println("\n Produto alterado.");
			} else {
				System.out.println("\n O produto n�o foi alterado.");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ProdutoException e) {
			System.out.println(e.getMessage());
		} 
	}

	private static void excluir() {
		System.out.println("\nExcluir Produto\n");
		try {
			int codigo = Console.readInt("Informe o c�digo: ");
			Produto obj = Banco.pesqProdutoCodigo(codigo);
			System.out.println(obj.toString());
			if (Console.readLine("CONFIRMA EXCLUS�O? S/N ").equalsIgnoreCase("S")) {
				Banco.excluirProduto(codigo);
				System.out.println("\nProduto exclu�do.");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ProdutoException e) {
			System.out.println(e.getMessage());
		} 
		
	}

	private static void incluir() {
		System.out.println("\nIncluir Produto\n");
		String nome;
		double preco = 0;
		while (true) {
			nome = Console.readLine("Nome: ").trim().toUpperCase();
			if (nome.isEmpty()) {
				System.out.println("Falta nome.");
				continue;
			} else {
				try {
					Banco.pesqProdutosNome(nome);
					System.out.println("Nome j� est� cadastrado.");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} catch (ProdutoException e) {
					break;
				}
			}
		}
		while (true) {
			preco = Console.readDouble("Pre�o: ");
			if (preco > 0) break;
			System.out.println("Pre�o inv�lido.");
		}
		try {
			Banco.incluirProduto(new Produto(0, nome, preco, null));
			System.out.println("\nProduto inclu�do.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
		
	}

	private static void estatistica() {
		System.out.println("\nEstat�stica de Produtos\n");
		try {
			ResultSet objResp = Banco.estatistica();
			objResp.next();
			System.out.println("TOTAL DE PRODUTOS: " + objResp.getInt("TOT"));
			System.out.println("MENOR PRE�O: " + objResp.getDouble("MENOR"));
			System.out.println("MAIOR PRE�O: " + objResp.getDouble("MAIOR"));
			System.out.println("PRE�O M�DIO: " + objResp.getDouble("MEDIA"));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	private static void pesqNome() {
		System.out.println("\nPesquisa de produtos pelo nome\n");
		try {
			String nome = Console.readLine("INFORME O NOME: ");
			ArrayList<Produto> lista = Banco.pesqProdutosNome(nome);
			for (Produto obj : lista) System.out.println(obj.toString());
			System.out.println("\nTOTAL DE PRODUTOS: " + lista.size());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ProdutoException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void pesqCodigo() {
		System.out.println("\nPesquisa de produto pelo c�digo\n");
		try {
			int codigo = Console.readInt("INFORME O C�DIGO: ");
			Produto obj = Banco.pesqProdutoCodigo(codigo);
			System.out.println(obj.toString());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ProdutoException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
