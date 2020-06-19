package geral;

import beans.Pedido;

public class PedidoDAO {

	public static void Incluir(Pedido pedido) throws Exception{
		String sql = "insert into Pedido (dmaPedido, horario, idCliente) "+
				"values('"+pedido.getDmaPedido()+"', '"+pedido.getHorario()+"',"
						+ " '"+pedido.getIdCliente() +"')";
		Conexao.execSql(sql);;
	}
	
	public static void Delete(Pedido pedido) throws Exception{
		String sql = "delete from Pedido where codigo ="+pedido.getCodigoPedido()+"";
		Conexao.execSql(sql);
	}
}
