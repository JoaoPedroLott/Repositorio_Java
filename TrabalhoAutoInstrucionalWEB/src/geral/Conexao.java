package geral;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexao {
	private static Connection con;
	private static Statement stm;
	
	public static void abrir() throws Exception{
		String driver = "org.sqlite.JDBC";
		String url = "jdbc:sqlite:C:/Users/João/Desktop/FUMEC/sqlite/AutoInstrucional.db";
		String usuario = null;
		String senha = null;
		Class.forName(driver);
		if (usuario == null && senha == null){
			con = DriverManager.getConnection(url);
		} else
			con = DriverManager.getConnection(url, usuario, senha);
		stm = con.createStatement();
	}
	
	public static void fechar() throws Exception{
		if (stm != null) stm.close();
		if (con != null) con.close();
		stm = null; con = null;
	}
	
	public static void execSql(String sql) throws Exception{
		if (con == null || stm == null) abrir();
		stm.execute(sql);
	}
	
	public static ResultSet getList(String sql) throws Exception{
		if (con == null || stm == null) abrir();
		return stm.executeQuery(sql);
	}
}