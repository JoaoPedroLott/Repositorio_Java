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
			// abrir conexão com o banco de dados
			Banco.abrirConexao();
			// chama o metodo do menu
			menu();
			// fechar a conexão com o banco de dados
			Banco.fecharConexao();
			System.out.println("\n Final da execução.");
			// siar
			System.exit(0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	// Metodo do menu do programa
	private static void menu() {
		int opcao = 0;
		
		do {
			System.out.println("\n TABELA DE PREÇOS \n");
			System.out.println("1- Pesquisa de produto pelo código.");
			System.out.println("2- Pesquisa de produtos pelo nome.");
			System.out.println("3- Estatística de produtos.");
			System.out.println("0- Sair");
			opcao = Console.readInt("Informe a opção: ");
			
			switch (opcao) {
			case 1:
				pesquisaCodigo();
				break;
			case 2:
				pesquisaNome();
				break;
			case 3: 
				estatistica();
				break;
			case 0: 
				break;
			default:
				System.out.println("Opção Invalida.");
				break;
			}
		} while (opcao!= 0);
	}

	// Metodo com as estatísticas da tabela de produtos
	private static void estatistica() {
		System.out.println("\n Estatística de produtos \n");
		try {
			ResultSet objResp = Banco.estatistica();
			objResp.next();
			System.out.println("TOTAL DE PRODUTOS: " + objResp.getInt("TOT"));
			System.out.println("MENOR PREÇO: " + objResp.getDouble("MENOR"));
			System.out.println("MAIOR PREÇO: " + objResp.getDouble("MAIOR"));
			System.out.println("PREÇO MEDIO: "+ objResp.getDouble("MEDIA"));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

	// Metodo para pesquisar o produto pelo nome
	private static void pesquisaNome() {
		System.out.println("\n Pesquisa de produtos pelo nome \n");
		try {
			// Recebe o nome do produto
			String nome = Console.readLine("Informe o nome: ");
			// Pesquisa o nome no banco
			ArrayList<Produto> lista = Banco.pesqProdutosNome(nome);
			// Se encontrar o nome no banco jogar para o toString
			for (Produto obj : lista) System.out.println(obj.toString());
			// Quantidade total de produtos encontrados
			System.out.println("TOTAL DE PRODUTOS: " + lista.size());
			
			//Exceptions
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ProdutoException e) {
			System.out.println(e.getMessage());
		}
	}

	// Metodo para pesquisar o produto pelo codigo
	private static void pesquisaCodigo() {
		System.out.println("\n Pesquisa de produto pelo código \n");
		try {
			// Recebe o codigo do produto
			int codigo = Console.readInt("Informe o código: ");
			// pesquisa o codigo digitado no banco
			Produto obj = Banco.pesqProdutoCodigo(codigo);
			// se encontrar coloca no toString
			System.out.println(obj.toString());
			
			// Exceptions
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ProdutoException e) {
			System.out.println(e.getMessage());
		}
	}

	
}
