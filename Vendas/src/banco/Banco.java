package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.firebirdsql.jdbc.FBDriver;
import dados.Item;
import dados.Venda;

import erros.VendaException;

public class Banco {

	public static Connection objConexao;
	/**
	 * Abrir Conexãocom BDVENDAS
	 * @throws SQLException
	 */
	public static void abrirConexao() throws SQLException{
		DriverManager.registerDriver(new FBDriver());
		objConexao = DriverManager.getConnection(
			"jdbc:firebirdsql:server1b/3050:D:/PROGRAM FILES/FIREBIRD/LTP4/BDVENDAS.GDB", 
	         "SYSDBA", "masterkey");
	}
	/**
	 * Fechar Conexão com BDVENDAS 
	 * @throws SQLException
	 */
	public static void fecharConexao() throws SQLException{
		objConexao.close();
	}
	/**
	 * Pesquisa Vendedor pelo código
	 * @param codVendedor
	 * @throws SQLException
	 * @throws VendaException
	 */
	public static void pesVendedor(int codVendedor) throws SQLException,VendaException{
		PreparedStatement objSQL = objConexao.prepareStatement(
				"SELECT * FROM VENDEDORES WHERE COD_VENDEDOR= ?");
		objSQL.setInt(1, codVendedor);
		ResultSet objResp = objSQL.executeQuery();
		if (!objResp.next()){
			throw new VendaException("Não Existe Vendedor para o Código." );
		}
	}
	/**
	 * Pesquisa Cliente pelo Código
	 * @param codCliente
	 * @throws SQLException
	 * @throws VendaException
	 */
	public static void pesCliente(int codCliente) throws SQLException,VendaException{
		PreparedStatement objSQL = objConexao.prepareStatement(
				"SELECT * FROM CLIENTES WHERE CODCLIENTE = ?");
		objSQL.setInt(1, codCliente);
		ResultSet objResp = objSQL.executeQuery();
		if (!objResp.next()){
			throw new VendaException("Não Existe Cliente para o Código." );
		}
	}
	/**
	 * Pesquisa Produto pelo Código
	 * @param codProduto
	 * @throws SQLException
	 * @throws VendaException
	 */
	public static void pesProduto(int codProduto) throws SQLException,VendaException{
		PreparedStatement objSQL = objConexao.prepareStatement(
				"SELECT * FROM TABPRODUTOS WHERE CODPRODUTO = ?");
		objSQL.setInt(1, codProduto);
		ResultSet objResp = objSQL.executeQuery();
		if (!objResp.next()){
			throw new VendaException("Não Existe Produto para o Código." );
		}
	}
	/**
	 * Incluir Venda
	 * @param objVenda
	 * @throws SQLException
	 */
	public static void incluirVenda(Venda objVenda) throws SQLException {

        try {
    		objConexao.setAutoCommit(false); // Controlar Transação pelo Aplicativo
            // Venda
            String atualizaSQL ="Insert INTO VENDAS  (COD_VENDEDOR, CODCLIENTE, DATA_VENDA ) VALUES (? ,? ,? )" ;
            PreparedStatement objSqlUpdate = objConexao.prepareStatement(atualizaSQL);
            objSqlUpdate.setInt(1,objVenda.getCodVendedor());
            objSqlUpdate.setInt(2,objVenda.getCodCliente());
            objSqlUpdate.setDate(3,objVenda.getDataVenda());
            objSqlUpdate.executeUpdate();
            
            ResultSet rs = objConexao.createStatement().executeQuery("SELECT CODVENDA FROM VENDAS WHERE CODVENDA = (SELECT MAX(CODVENDA) FROM VENDAS)");
            rs.next();
            
            // Itens            
            for (Item objItem : objVenda.getItens()) {
                String comandoSQL = "Insert INTO ITENS (CODVENDA, CODPRODUTO, QUANTIDADE, VALOR ) VALUES (? ,? ,? ,? )";
                objSqlUpdate = objConexao.prepareStatement(comandoSQL);
                objSqlUpdate.setInt(1,rs.getInt("CODVENDA"));
                objSqlUpdate.setInt(2,objItem.getCodProduto());
                objSqlUpdate.setInt(3,objItem.getQuantidade());
                objSqlUpdate.setDouble(4,objItem.getValor());
                objSqlUpdate.executeUpdate();
            }
            objConexao.commit(); // Concluir Transação

        } catch (SQLException objSQLException) {
        	objConexao.rollback(); // Desfaz Transação
            throw objSQLException;
        } finally {
        	objConexao.setAutoCommit(true); // Habilitar controle automatico de Transação pelo SGDB
        }
		
	}	
	public static ResultSet pesqVenda(int codigo) throws SQLException {
		PreparedStatement objSQL = objConexao.prepareStatement(
			"SELECT VENDAS.CODVENDA, COD_VENDEDOR, CODCLIENTE, DATA_VENDA , COD_ITEM, " +
			"CODPRODUTO, QUANTIDADE, VALOR FROM VENDAS JOIN ITENS ON VENDAS.CODVENDA=ITENS.CODVENDA " +
			"WHERE VENDAS.CODVENDA = ?");
		objSQL.setInt(1, codigo);
		return objSQL.executeQuery();
	}
	
}
