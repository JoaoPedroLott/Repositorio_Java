package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.firebirdsql.jdbc.FBDriver;

import dados.Pessoa;

public class Banco {
	public static Connection objCon;
	
	public static void abrirConexao() throws SQLException{
		DriverManager.registerDriver(new FBDriver());
		objCon = DriverManager.getConnection(
				"jdbc:firebirdsql:server1b/3050:D:/PROGRAM FILES/FIREBIRD/LTP4/BDPESSOAS.GDB", 
				"SYSDBA", "masterkey");
	}
	public static void fecharConexao() throws SQLException{
		objCon.close();
	}
	public static void incluirPessoa(Pessoa objPessoa) throws SQLException{
		PreparedStatement objCons = objCon.prepareStatement(
				"SELECT * FROM AGENDA WHERE UPPER(NOME) = ? AND NASCIMENTO = ?");
		objCons.setString(1, objPessoa.getNome().toUpperCase());
		objCons.setDate(2, objPessoa.getNascimento());
		ResultSet resposta = objCons.executeQuery();
		if (resposta.next()) {
			throw new SQLException("já existe no cadastro uma pessoa com o mesmo nome e data de nascimento.");
		}
		
		PreparedStatement objSQL = objCon.prepareStatement(
				"INSERT INTO AGENDA (NOME, TELEFONE, NASCIMENTO, EMAIL ) VALUES (?,?,?,?)");
		objSQL.setString(1, objPessoa.getNome());
		objSQL.setString(2, objPessoa.getTelefone());
		objSQL.setDate(3, objPessoa.getNascimento());
		objSQL.setString(4, objPessoa.getEmail());
		objSQL.executeUpdate();
	}
	public static void alterarPessoa(Pessoa objPessoa) throws SQLException{
		PreparedStatement objSQL = objCon.prepareStatement(
				"UPDATE AGENDA SET NOME = ? , TELEFONE = ?, NASCIMENTO = ?, EMAIL= ? WHERE CODIGO = ? ");
		objSQL.setString(1, objPessoa.getNome());
		objSQL.setString(2, objPessoa.getTelefone());
		objSQL.setDate(3, objPessoa.getNascimento());
		objSQL.setString(4, objPessoa.getEmail());
		objSQL.setInt(5, objPessoa.getCodigo());
		objSQL.executeUpdate();
	}
	public static void excluirPessoa(int codigo) throws SQLException{
		PreparedStatement objSQL = objCon.prepareStatement(
				"DELETE FROM AGENDA WHERE CODIGO = ?");
		objSQL.setInt(1, codigo);
		objSQL.executeUpdate();		
	}
	public static Pessoa consPessoaCodigo(int codigo) throws SQLException{
		PreparedStatement objSQL = objCon.prepareStatement(
				"SELECT * FROM AGENDA WHERE CODIGO = ?");
		objSQL.setInt(1, codigo);
		ResultSet resposta = objSQL.executeQuery();
		if (resposta.next()) {
			return new Pessoa(
					resposta.getInt("CODIGO"), 
					resposta.getString("NOME"), 
					resposta.getString("TELEFONE"), 
					resposta.getDate("NASCIMENTO"), 
					resposta.getString("EMAIL"));	
		} else throw new SQLException("Não existe pessoa para o código.");
		
	}
	public static ArrayList<Pessoa> consPessoaNome(String nome) throws SQLException{
		PreparedStatement objSQL = objCon.prepareStatement(
				"SELECT * FROM AGENDA WHERE UPPER(NOME) LIKE ? ORDER BY NOME");
		objSQL.setString(1, "%" + nome.toUpperCase() + "%");
		ResultSet resposta = objSQL.executeQuery();
		ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
		int tot=0;
		while (resposta.next()) {
			lista.add(new Pessoa(
					resposta.getInt("CODIGO"), 
					resposta.getString("NOME"), 
					resposta.getString("TELEFONE"), 
					resposta.getDate("NASCIMENTO"), 
					resposta.getString("EMAIL")));
			tot++;
		}
		if (tot>0)	return lista;
		else throw new SQLException("Não existe pessoa para o nome informado.");
		
	}
	public static ArrayList<Pessoa> consPessoaMesNasc(int mes) throws SQLException{
		PreparedStatement objSQL = objCon.prepareStatement(
				"SELECT * FROM AGENDA WHERE EXTRACT(MONTH FROM NASCIMENTO) = ? ORDER BY NOME");
		objSQL.setInt(1,  mes);
		ResultSet resposta = objSQL.executeQuery();
		ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
		int tot=0;
		while (resposta.next()) {
			lista.add(new Pessoa(
					resposta.getInt("CODIGO"), 
					resposta.getString("NOME"), 
					resposta.getString("TELEFONE"), 
					resposta.getDate("NASCIMENTO"), 
					resposta.getString("EMAIL")));
			tot++;
		}
		if (tot>0)	return lista;
		else throw new SQLException("Não existe pessoa para o mês informado.");

	}
}
