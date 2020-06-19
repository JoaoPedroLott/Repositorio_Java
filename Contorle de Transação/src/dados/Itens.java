package dados;

import utilitarios.LtpUtil;

public class Itens {

	private int codigoIten;
	private int codigoVenda;
	private int codigoProduto;
	private int quantidade;
	private float valor;
	
	public Itens(int codigoIten, int codigoVenda, int codigoProduto,
			int quantidade, float valor) {
		super();
		this.codigoIten = codigoIten;
		this.codigoVenda = codigoVenda;
		this.codigoProduto = codigoProduto;
		this.quantidade = quantidade;
		this.valor = valor;
	}

	public int getCodigoIten() {
		return codigoIten;
	}

	public void setCodigoIten(int codigoIten) {
		this.codigoIten = codigoIten;
	}

	public int getCodigoVenda() {
		return codigoVenda;
	}

	public void setCodigoVenda(int codigoVenda) {
		this.codigoVenda = codigoVenda;
	}

	public int getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	
	public String toString() {
		return
				"Código Iten: " + codigoIten + "\n" +
				"Código Venda: " + codigoVenda + "\n" +
				"Código Produto: " + codigoProduto + "\n" +
				"Quantidade: " + quantidade + "\n" + 
				"Valor: " + LtpUtil.formatarValor(valor, "#,##0.00") + "\n";
	}
}
