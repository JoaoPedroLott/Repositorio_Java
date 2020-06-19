package dados;

import java.sql.Date;

import utilitarios.LtpUtil;

public class Venda {

	private int codigoVenda;
	private int codigoVendedor;
	private int codigoCliente;
	private Date data;
	
	public Venda(int codigoVenda, int codigoVendedor, int codigoCliente,
			Date data) {
		super();
		this.codigoVenda = codigoVenda;
		this.codigoVendedor = codigoVendedor;
		this.codigoCliente = codigoCliente;
		this.data = data;
	}

	public int getCodigoVenda() {
		return codigoVenda;
	}

	public void setCodigoVenda(int codigoVenda) {
		this.codigoVenda = codigoVenda;
	}

	public int getCodigoVendedor() {
		return codigoVendedor;
	}

	public void setCodigoVendedor(int codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public String toString() {
		return
				"Código Venda: " + codigoVenda + "\n" +
				"Código Vendedor: " + codigoVendedor + "\n" +
				"Código Cliente: " + codigoCliente + "\n" +
				"Data: " + LtpUtil.formatarData(data, "dd/MM/yyyy") + "\n";
	}
}
