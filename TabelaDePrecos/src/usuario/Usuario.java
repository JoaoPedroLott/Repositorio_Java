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
			System.out.println("\nFinal da execução.");
			System.exit(0);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void menu() {
		int opcao = 0;
		do {
			System.out.println("\nTABELA DE PREÇOS");
			System.out.println("1-PESQUISA DE PRODUTO PELO CÓDIGO");
			System.out.println("2-PESQUISA DE PRODUTOS PELO NOME");
			System.out.println("3-ESTATÍSTICA DE PRODUTOS");
			System.out.println("4-INCLUIR PRODUTO");
			System.out.println("5-EXCLUIR PRODUTO");
			System.out.println("6-ALTERAR PRODUTO");
			System.out.println("0-SAIR");
			opcao = Console.readInt("Informe a opção: ");
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
					System.out.println("Opção inválida.");
					break;
			}
		} while (opcao!=0);

		
	}

	private static void alterar() {
		System.out.println("\nAlterar Produto\n");
		boolean alterou = false;
		try {
			int codigo = Console.readInt("Informe o código: ");
			Produto obj = Banco.pesqProdutoCodigo(codigo);
			System.out.println(obj.toString());
			String nome = Console.readLine("Informe o nome se quiser alterar: ").trim().toUpperCase();
			if (!nome.isEmpty()) {
				obj.setNome(nome);
				alterou = true;
			}
			double preco = Console.readDouble("Informe o preço se quiser alterar: ");
			if (preco > 0) {
				obj.setPreco(preco);
				alterou = true;
			}
			if (alterou) {
				Banco.alterarProduto(obj);
				System.out.println("\n Produto alterado.");
			} else {
				System.out.println("\n O produto não foi alterado.");
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
			int codigo = Console.readInt("Informe o código: ");
			Produto obj = Banco.pesqProdutoCodigo(codigo);
			System.out.println(obj.toString());
			if (Console.readLine("CONFIRMA EXCLUSÃO? S/N ").equalsIgnoreCase("S")) {
				Banco.excluirProduto(codigo);
				System.out.println("\nProduto excluído.");
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
					System.out.println("Nome já está cadastrado.");
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				} catch (ProdutoException e) {
					break;
				}
			}
		}
		while (true) {
			preco = Console.readDouble("Preço: ");
			if (preco > 0) break;
			System.out.println("Preço inválido.");
		}
		try {
			Banco.incluirProduto(new Produto(0, nome, preco, null));
			System.out.println("\nProduto incluído.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
		
	}

	private static void estatistica() {
		System.out.println("\nEstatística de Produtos\n");
		try {
			ResultSet objResp = Banco.estatistica();
			objResp.next();
			System.out.println("TOTAL DE PRODUTOS: " + objResp.getInt("TOT"));
			System.out.println("MENOR PREÇO: " + objResp.getDouble("MENOR"));
			System.out.println("MAIOR PREÇO: " + objResp.getDouble("MAIOR"));
			System.out.println("PREÇO MÉDIO: " + objResp.getDouble("MEDIA"));
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
		System.out.println("\nPesquisa de produto pelo código\n");
		try {
			int codigo = Console.readInt("INFORME O CÓDIGO: ");
			Produto obj = Banco.pesqProdutoCodigo(codigo);
			System.out.println(obj.toString());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ProdutoException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
