package geral;

import java.sql.ResultSet;
import java.util.ArrayList;
import beans.Funcionario;;

public class FuncionarioDAO {

	public static void Incluir(Funcionario funcionario) throws Exception{
		String sql = "insert into Funcionario (login, senha, nome) "+
				"values('"+funcionario.getLoginFuncionario()+"', '"+funcionario.getSenhaFuncionario()+"',"
						+ " '"+funcionario.getNomeFuncionario()+"')";
		Conexao.execSql(sql);;
	}
	
	public static void Delete(Funcionario funcionario) throws Exception{
		String sql = "delete from Funcionario where login ="+funcionario.getLoginFuncionario()+"";
		Conexao.execSql(sql);
	}
	
	public static ArrayList<Funcionario> getData() throws Exception {
		String sql = "select * from Funcionario order by nome";
		ResultSet rs = Conexao.getList(sql);
		
		if (rs == null)
			throw new Exception("Não existe registros");
		
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		while (rs.next()) {
			Funcionario funcionario = new Funcionario();
			funcionario.setLoginFuncionario(rs.getString("login"));
			funcionario.setSenhaFuncionario(rs.getString("senha"));
			funcionario.setNomeFuncionario(rs.getString("nome"));
			funcionarios.add(funcionario);
		}
		return funcionarios;
	}
	
	public static void Alterar(Funcionario funcionario) throws Exception {
		String sql = "update Funcionario set senha ='"+funcionario.getSenhaFuncionario()+
				"',set nome ='"+funcionario.getNomeFuncionario()+"'"
				+ " where login = '"+funcionario.getLoginFuncionario()+"'";
		Conexao.execSql(sql);
	}
}