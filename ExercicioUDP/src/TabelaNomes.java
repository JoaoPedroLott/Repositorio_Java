import java.util.HashMap;
import java.util.Map;

public class TabelaNomes {

	private static Map<String, Host> listaHost = new HashMap<String, Host>();

	public static String verificaComando(String dataInput) throws Exception {

		if (dataInput.startsWith("insert")) {
			return TabelaNomes.inserirHost(dataInput);
		} else if (dataInput.startsWith("search")) {
			return TabelaNomes.pesquisarHost(dataInput);
		} else {
			throw new Exception("Comando não reconhecido.");
		}

	}

	private static String inserirHost(String dataInput) {

		String[] insere = dataInput.split(" ");
		if (insere.length != 4)
			return "0";

		String nomeLogico = insere[1];
		if (listaHost.containsKey(nomeLogico))
			return "0";

		Host host = new Host(insere[2], insere[3]);
		listaHost.put(nomeLogico, host);

		return "1";

	}

	private static String pesquisarHost(String dataInput) {

		String[] pesquisa = dataInput.split(" ");
		if (pesquisa.length != 2)
			return "-1";

		String nomeLogico = pesquisa[1];
		Host host = listaHost.get(nomeLogico);

		if (host == null)
			return "-1";

		return host.getPorta() + " " + host.getnomeHost();

	}

}
