package cliente;

public class Cliente {

	private GerenciadorConexao gerenciadorConexao;

	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.inicia();
	}

	public void inicia() {
		GerenciadorConfiguracaoCliente configuracaoCliente = new GerenciadorConfiguracaoCliente("localhost", 8080);
		this.gerenciadorConexao = new GerenciadorConexao(configuracaoCliente);
		this.gerenciadorConexao.estabeleConexao();
	}
}
