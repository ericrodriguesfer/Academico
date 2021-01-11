package cliente;

public class GerenciadorConfiguracaoCliente {
	private String host;
	private int porta;

	public GerenciadorConfiguracaoCliente(String host, int porta) {
		this.host = host;
		this.porta = porta;
	}

	public String getHost() {
		return this.host;	
	}

	public int getPorta() {
		return this.porta;
	}
}
