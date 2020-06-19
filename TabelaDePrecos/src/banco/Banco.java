package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.firebirdsql.jdbc.FBDriver;
import org.firebirdsql.pool.ResultSetHandler;
import dados.Produto;
import erro.ProdutoException;

public class Banco {
	public static Connection objCon;
	
	public static void abrirConexao() throws SQLException {
		DriverManager.registerDriver(new FBDriver());
		objCon = DriverManager.getConnection(
				"jdbc:firebirdsql:server1b/3050:D:/PROGRAM FILES/FIREBIRD/LTP4/BDPRODUTOS.GDB", 
				"SYSDBA", "masterkey");
	}
	
	public static void fecharConexao() throws SQLException {
		objCon.close();
	}

	public static Produto pesqProdutoCodigo(int codigo) 
		throws SQLException, ProdutoException {
		PreparedStatement objSQL = 
			objCon.prepareStatement("SELECT * FROM TABPRODUTOS WHERE CODIGO = ?");
		objSQL.setInt(1, codigo);
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
	
	public static ArrayList<Produto> pesqProdutosNome(String nome) throws SQLException, ProdutoException {
		PreparedStatement objSQL = 
				objCon.prepareStatement("SELECT * FROM TABPRODUTOS WHERE PRODUTO LIKE ? ORDER BY PRODUTO");
		objSQL.setString(1, "%"+nome+"%");
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
	
	public static ResultSet estatistica() throws SQLException {
		return objCon.createStatement().executeQuery("SELECT COUNT(*) TOT, MIN(PRECO) MENOR, MAX(PRECO) MAIOR, AVG(PRECO) MEDIA FROM TABPRODUTOS");
	}
	
	public static void incluirProduto(Produto obj) throws SQLException {
		PreparedStatement objSQL = 
			objCon.prepareStatement("INSERT INTO TABPRODUTOS (PRODUTO, PRECO, DATAPRECO) VALUES (? , ?, CURRENT_DATE)");
		objSQL.setString(1, obj.getNome());
		objSQL.setDouble(2, obj.getPreco());
		objSQL.executeUpdate();
	}
	
	public static void excluirProduto(int codigo) throws SQLException{
		PreparedStatement objSQL = 
				objCon.prepareStatement("DELETE FROM TABPRODUTOS WHERE CODIGO = ?");
			objSQL.setInt(1, codigo);
			objSQL.executeUpdate();		
	}
	
	public static void alterarProduto(Produto obj) throws SQLException{
		PreparedStatement objSQL = 
				objCon.prepareStatement("UPDATE TABPRODUTOS SET PRODUTO = ?, PRECO = ?, DATAPRECO = CURRENT_DATE WHERE CODIGO = ?");
			objSQL.setString(1, obj.getNome());
			objSQL.setDouble(2, obj.getPreco());
			objSQL.setInt(3, obj.getCodigo());
			objSQL.executeUpdate();			
	}
	
	public static boolean PesqProduto(Produto obj) throws SQLException {
		PreparedStatement objSQL = 
				objCon.prepareStatement("SELECT * FROM TABPRODUTOS WHERE PRODUTO = ? AND CODIGO <> ? ");
		objSQL.setString(1, obj.getNome());
		objSQL.setInt(2, obj.getCodigo());
		ResultSet resp = objSQL.executeQuery();
		if (resp.next()) {
			return true;
		} else {
			return false;
		}
		
	}
}









