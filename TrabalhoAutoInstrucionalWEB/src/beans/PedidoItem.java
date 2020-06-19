package beans;

public class PedidoItem {

	private int codigoPedidoItem;
	private int idPedido;
	private int idLivro;
	private int quantidade;
	private double unitario;
	private double total;
	
	public PedidoItem () {
		
	}

	public int getCodigoPedidoItem() {
		return codigoPedidoItem;
	}

	public void setCodigoPedidoItem(int codigoPedidoItem) {
		this.codigoPedidoItem = codigoPedidoItem;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getUnitario() {
		return unitario;
	}

	public void setUnitario(double unitario) {
		this.unitario = unitario;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "PedidoItem [codigoPedidoItem=" + codigoPedidoItem + ", idPedido=" + idPedido + ", idLivro=" + idLivro
				+ ", quantidade=" + quantidade + ", unitario=" + unitario + ", total=" + total + "]";
	}
	
	
}
