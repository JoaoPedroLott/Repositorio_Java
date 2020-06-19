package servidor;

import java.util.HashMap;

public class TabelaClientesServidor {

	private HashMap<String, String> clientes = new HashMap<String, String>();

	public HashMap<String, String> getClients() {
		return clientes;
	}

	public void setClients(HashMap<String, String> clients) {
		this.clientes = clients;
	}
}
