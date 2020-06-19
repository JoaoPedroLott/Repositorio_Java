package geral;

import java.sql.ResultSet;
import java.util.ArrayList;
import beans.Assunto;

public class AssuntoDAO {

	public static void Incluir(Assunto assunto) throws Exception{
		String sql = "insert into Assunto (codigo, nome) "+
				"values('"+assunto.getCodigoAssunto()+"', '"+assunto.getNomeAssunto()+"')";
		Conexao.execSql(sql);;
	}
	
	public static void Delete(Assunto assunto) throws Exception{
		String sql = "delete from Assunto where codigo ="+assunto.getCodigoAssunto()+"";
		Conexao.execSql(sql);
	}
	
	public static ArrayList<Assunto> getData() throws Exception {
		String sql = "select * from Assunto order by nome";
		ResultSet rs = Conexao.getList(sql);
		
		if (rs == null)
			throw new Exception("Não existe registros");
		
		ArrayList<Assunto> assuntos = new ArrayList<Assunto>();
		
		while (rs.next()) {
			Assunto assunto = new Assunto();
			assunto.setCodigoAssunto(rs.getInt("codigo"));
			assunto.setNomeAssunto(rs.getString("nome"));
			assuntos.add(assunto);
		}
		return assuntos;
	}
	
	public static void Alterar(Assunto assunto) throws Exception {
		String sql = "update Assunto set nome ='"
				+assunto.getNomeAssunto()+"' where codigo = '"+assunto.getCodigoAssunto()+"'";
		Conexao.execSql(sql);
	}
}
