package dados;

import java.sql.Date;
import java.util.ArrayList;

import utilitarios.LtpUtil;

public class Venda {
	//
	private int codVenda;
	private int codVendedor;
	private int codCliente;
	private Date dataVenda;
	//
	private ArrayList<Item> itens;
	//
	public Venda(int codVenda, int codVendedor, int codCliente, Date dataVenda) {
		this.codVenda = codVenda;
		this.codVendedor = codVendedor;
		this.codCliente = codCliente;
		this.dataVenda = dataVenda;
	}
	//
	public int getCodVenda() {
		return codVenda;
	}
	public void setCodVenda(int codVenda) {
		this.codVenda = codVenda;
	}
	public int getCodVendedor() {
		return codVendedor;
	}
	public void setCodVendedor(int codVendedor) {
		this.codVendedor = codVendedor;
	}
	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	public Date getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	public ArrayList<Item> getItens() {
		return itens;
	}
	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}
	public String toString() {
		return 
			"Cod.Venda: " + codVenda + "\n" +
			"Cod.Cliente: " + codCliente + "\n" +
			"Data Venda: " + LtpUtil.formatarData(dataVenda, "dd/MM/yyyy") + "\n";
	}
}
