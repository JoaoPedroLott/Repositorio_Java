package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.firebirdsql.jdbc.FBDriver;

import dados.Produto;
import erro.ProdutoException;

public class Banco {

	public static Connection objcon;
	
	// Metodo para abrir conexao com o banco de dados
	public static void abrirConexao() throws SQLException {
		DriverManager.registerDriver(new FBDriver());
		objcon = DriverManager.getConnection(
				"jdbc:firebirdsql:server1b/3050:D:/PROGRAM FILES/FIREBIRD/LTP4/BDPRODUTOS.GDB", 
				"SYSDBA", "masterkey");
	}
	
	// Metodo para fechar a conexão com o banco de dados
	public static void fecharConexao() throws SQLException {
		objcon.close();
	}

	// Metodo para pesquisar produto pelo codigo
	public static Produto pesqProdutoCodigo(int codigo) throws SQLException, ProdutoException{
		PreparedStatement objSQL = 
			objcon.prepareStatement("SELECT * FROM TABPRODUTOS WHERE CODIGO = ?");
		objSQL.setInt(1, codigo);
		// executeQuery, executa o comando de SQL colocado no prepareStatemente
		ResultSet objResp = objSQL.executeQuery();
		if (objResp.next()) {
			return new Produto(
					objResp.getInt("CODIGO"), 
					objResp.getString("PRODUTO"), 
					objResp.getDouble("PRECO"), 
					objResp.getDate("DATAPRECO"));
		} else {
			throw new ProdutoException("Não existe produto para o código.");
		}	
	}
	
	// Metodo para pesquisar produto pelo nome
	public static ArrayList<Produto> pesqProdutosNome(String nome) throws SQLException, ProdutoException {
		
		PreparedStatement objSQL = objcon.prepareStatement("SELECT * FROM TABPRODUTOS WHERE PRODUTO LIKE ? ORDER BY PRODUTO");
		objSQL.setString(1, "%"+ nome +"%");
		// executeQuery, executa o comando de SQL colocado no prepareStatemente
		ResultSet objResp = objSQL.executeQuery();
		ArrayList<Produto> listaProd = new ArrayList<Produto>();
		while (objResp.next()) {
			listaProd.add(new Produto(
					objResp.getInt("CODIGO"), 
					objResp.getString("PRODUTO"), 
					objResp.getDouble("PRECO"), 
					objResp.getDate("DATAPRECO")));
		}
		if (listaProd.isEmpty()) {
			throw new ProdutoException("Não existe produto para o nome.");
		} else {
			return listaProd;
		}
	}
	
	// Metodo de estatisticas (total de produtos, menor valor, maior valor e media)
	public static ResultSet estatistica() throws SQLException {
		
		return objcon.createStatement().executeQuery("SELECT COUNT(*) TOT, MIN(PRECO) MENOR, MAX(PRECO) MAIOR, AVG(PRECO) MEDIA FROM TABPRODUTOS");
	}

}

