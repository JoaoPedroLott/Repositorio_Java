package usuario;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dados.Item;
import dados.Venda;

import erros.VendaException;

import utilitarios.Console;
import utilitarios.LtpUtil;
import banco.Banco;

public class Usuario {

	/**
	 * Main 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Banco.abrirConexao(); // Abrir Conexão
			menu(); // Menu
			Banco.fecharConexao(); //Fechar Conexão
			System.out.println("\nFinal do aplicativo.");
			System.exit(0);
		} catch (SQLException e) {
			System.out.println("Falha conexão - " + e.getMessage());
			System.exit(1);
		}
	}
	/**
	 * Menu
	 */
	private static void menu() {
		int opcao=0;
		do {
			System.out.println("\nMENU TABELA VENDAS");
			System.out.println("1-INCLUIR VENDA");
			System.out.println("2-PESQUISAR VENDA PELO CÓDIGO");
			System.out.println("0-SAIR");
			opcao = Console.readInt("Opção: ");
			switch (opcao) {
				case 1:
					incluirVenda();
					break;
				case 2:
					pesqVendaCod();
					break;
				case 0:
					break;
				default:
					System.out.println("Opção inválida.");
					break;
			}
			
		} while (opcao!=0);
		
	}

	private static void pesqVendaCod() {
		System.out.println("\n" + "Pesquisar venda pelo código\n");
		try {
			int codigo = Console.readInt("Informe o código da venda: ");
			ResultSet resp = Banco.pesqVenda(codigo);
			while (resp.next()) {
				System.out.println("\nCódigo Venda: " + resp.getInt("CODVENDA"));
				System.out.println("Código Vendedor: " + resp.getInt("COD_VENDEDOR"));
				System.out.println("Código Cliente: " + resp.getInt("CODCLIENTE"));
				System.out.println("Data Venda: " + LtpUtil.formatarData(resp.getDate("DATA_VENDA"), "dd/MM/yyyy"));
				System.out.println("Código Item: " + resp.getInt("COD_ITEM"));
				System.out.println("Código Produto: " + resp.getInt("CODPRODUTO"));
				System.out.println("Quantidade: " + resp.getInt("QUANTIDADE"));
				System.out.println("Valor: " + LtpUtil.formatarValor(resp.getDouble("VALOR"),"#,##0.00") + "\n");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	/**
	 * Incluir Venda
	 */
	private static void incluirVenda() {
		System.out.println("\n" + "Incluir venda\n");
		//
		// Venda
		//
		int codVenda=0;
		int codVendedor= 0;
		try {
			codVendedor=Console.readInt("Código do vendedor: ");
			Banco.pesVendedor(codVendedor);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return;
		} catch (VendaException e) {
			System.out.println(e.getMessage());
			return;
		}
		int codCliente = 0;
		try {
			codCliente=Console.readInt("Código do cliente: ");
			Banco.pesCliente(codCliente);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return;
		} catch (VendaException e) {
			System.out.println(e.getMessage());
			return;
		}
		Date dataVenda = new Date(System.currentTimeMillis());
		//
		Venda objVenda = new Venda(codVenda, codVendedor, codCliente, dataVenda);
		//
		//
		//
		ArrayList<Item> itens = new ArrayList<Item>();
		
		int numItens = Console.readInt("Número de itens: ");
		if (numItens <= 0) return;
		//
		// Itens
		//
		for (int i = 1; i <= numItens; i++) {
			System.out.println();
			int codItem = 0;
			int codProduto = 0;
			while (true) {
				try {
					codProduto = Console.readInt("Código do produto: ");
					Banco.pesProduto(codProduto);
					break;
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					return;
				} catch (VendaException e) {
					System.out.println(e.getMessage());
					continue;
				}
			}
			int quantidade = Console.readInt("Quantidade: ");
			double valor = Console.readDouble("Valor: ");
			itens.add(new Item(codItem, codVenda, codProduto, quantidade, valor));
			
		}
		//
		objVenda.setItens(itens);
		//
		// Registrar a venda no Banco de Dados
		//
		try {
			Banco.incluirVenda(objVenda);
			System.out.println("\nVenda Cadastrada.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
		
	}

}
