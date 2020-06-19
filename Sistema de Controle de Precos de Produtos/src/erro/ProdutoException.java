package erro;

@SuppressWarnings("serial")
public class ProdutoException extends Exception {

	public ProdutoException(String descricaoErro) {
		super(descricaoErro);
	}
}
