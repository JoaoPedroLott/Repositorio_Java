package dados;

import utilitarios.LtpUtil;

public class Item {
	//
	private int codItem;
	private int codVenda;
	private int codProduto;
	private int quantidade;
	private double valor;
	//
	public Item(int codItem, int codVenda, int codProduto, int quantidade,
			double valor) {
		this.codItem = codItem;
		this.codVenda = codVenda;
		this.codProduto = codProduto;
		this.quantidade = quantidade;
		this.valor = valor;
	}
	//
	public int getCodItem() {
		return codItem;
	}
	public void setCodItem(int codItem) {
		this.codItem = codItem;
	}
	public int getCodVenda() {
		return codVenda;
	}
	public void setCodVenda(int codVenda) {
		this.codVenda = codVenda;
	}
	public int getCodProduto() {
		return codProduto;
	}
	public void setCodProduto(int codProduto) {
		this.codProduto = codProduto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String toString() {
		return
			"Cod.Item: " + codItem + "\n" +
			"Cod.Venda: " + codVenda + "\n" +
			"Cod.Produto: " + codProduto + "\n" +
			"Quantidade: " + quantidade + "\n" +
			"Valor: " + LtpUtil.formatarValor(valor, "#,##0.00") + "\n";
	}
	
}
