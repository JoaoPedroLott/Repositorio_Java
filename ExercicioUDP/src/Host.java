public class Host {

	private String nomeHost;
	private String porta;

	public Host(String nomeHost, String porta) {
		this.nomeHost = nomeHost;
		this.porta = porta;
	}

	public String getnomeHost() {
		return nomeHost;
	}

	public void setnomeHost(String nomeHost) {
		this.nomeHost = nomeHost;
	}

	public String getPorta() {
		return porta;
	}

	public void setPorta(String porta) {
		this.porta = porta;
	}
}
