package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.firebirdsql.jdbc.FBDriver;
import dados.Venda;
import erro.VendaException;

public class Banco {

public static Connection objcon;
	
	// Metodo para abrir conexao com o banco de dados
	public static void abrirConexao() throws SQLException {
		DriverManager.registerDriver(new FBDriver());
		objcon = DriverManager.getConnection(
				"jdbc:firebirdsql:server1b/3050:D:/PROGRAM FILES/FIREBIRD/LTP4/BDVendas.GDB", 
				"SYSDBA", "masterkey");
	}
	
	// Metodo para fechar a conexão com o banco de dados
	public static void fecharConexao() throws SQLException {
		objcon.close();
	}
	
	public static void CadastrarVenda(Venda obj) throws SQLException {
		PreparedStatement objSQL = 
			objcon.prepareStatement("INSERT INTO VENDAS (COD_VENDEDOR, CODCLIENTE, DATA_VENDA) VALUES (? ,?, ?)");
		objSQL.setInt(1, obj.getCodigoVendedor());
		objSQL.setInt(2, obj.getCodigoCliente());
		objSQL.setDate(3, obj.getData());
		objSQL.executeUpdate();
	}
	
	public static Venda pesqVendaCodigo(int codigo) 
			throws SQLException, VendaException {
			PreparedStatement objSQL = 
				objcon.prepareStatement("SELECT * FROM VENDAS WHERE CODVENDA = ?");
			objSQL.setInt(1, codigo);
			ResultSet objResp = objSQL.executeQuery();
			if (objResp.next()) {
	            return new Venda(
	            		objResp.getInt("CODVENDA"), 
	            		objResp.getInt("COD_VENDEDOR"), 
	            		objResp.getInt("CODCLIENTE"), 
	            		objResp.getDate("DATA_VENDA")); 			
			} else {
				throw new VendaException("Não existe venda para o código.");
			}
		}
	
}
