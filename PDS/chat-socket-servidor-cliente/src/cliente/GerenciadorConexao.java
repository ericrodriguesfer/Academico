package cliente;

import java.net.Socket;

public class GerenciadorConexao {
	private GerenciadorConfiguracaoCliente configuracaoCliente;
	private GerenciadorEnvioMensagemServidor gerenciadorEnvioMensagemServidor;

	public GerenciadorConexao(	GerenciadorConfiguracaoCliente configuracaoCliente) {
		this.configuracaoCliente = configuracaoCliente;

	}

	public void estabeleConexao() {
		try {
			Socket cliente = new Socket(this.configuracaoCliente.getHost(), this.configuracaoCliente.getPorta());
			System.out.println("Conexão estabelecida com o servidor: " + this.configuracaoCliente.getHost() + ":" + this.configuracaoCliente.getPorta());

			while (true) {
				this.gerenciadorEnvioMensagemServidor = new GerenciadorEnvioMensagemServidor(cliente);
				this.gerenciadorEnvioMensagemServidor.enviarMensagens();
				
				cliente.close();
				System.out.println("Cliente se desconectou do servidor: " + this.configuracaoCliente.getHost() + ":" + this.configuracaoCliente.getPorta());
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			System.out.println("Conexão Falhou!");
		}
	}
}
