package beans;

public class Pedido {
	
	private int codigoPedido;
	private String dmaPedido;
	private String horario;
	private int idCliente;
	
	public Pedido () {
		
	}

	public int getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(int codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public String getDmaPedido() {
		return dmaPedido;
	}

	public void setDmaPedido(String dmaPedido) {
		this.dmaPedido = dmaPedido;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return "Pedido [codigoPedido=" + codigoPedido + ", dmaPedido=" + dmaPedido + ", horario=" + horario
				+ ", idCliente=" + idCliente + "]";
	}
}
