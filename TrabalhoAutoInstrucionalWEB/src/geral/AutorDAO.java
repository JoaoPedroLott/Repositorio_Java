package geral;

import java.sql.ResultSet;
import java.util.ArrayList;
import beans.Autor;

public class AutorDAO {

	public static void Incluir(Autor autor) throws Exception{
		String sql = "insert into Autor (codigo, nome) "+
				"values('"+autor.getCodigoAutor()+"', '"+autor.getNomeAutor()+"')";
		Conexao.execSql(sql);;
	}
	
	public static void Delete(Autor autor) throws Exception{
		String sql = "delete from Autor where codigo ="+autor.getCodigoAutor()+"";
		Conexao.execSql(sql);
	}
	
	public static ArrayList<Autor> getData() throws Exception {
		String sql = "select * from Autor order by nome";
		ResultSet rs = Conexao.getList(sql);
		
		if (rs == null)
			throw new Exception("Não existe registros");
		
		ArrayList<Autor> autores = new ArrayList<Autor>();
		
		while (rs.next()) {
			Autor autor = new Autor();
			autor.setCodigoAutor(rs.getInt("codigo"));
			autor.setNomeAutor(rs.getString("nome"));
			autores.add(autor);
		}
		return autores;
	}
	
	public static void Alterar(Autor autor) throws Exception {
		String sql = "update Autor set nome ='"
				+autor.getNomeAutor()+"' where codigo = '"+autor.getCodigoAutor()+"'";
		Conexao.execSql(sql);
	}
}
