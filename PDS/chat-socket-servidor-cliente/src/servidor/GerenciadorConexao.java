package servidor;

import java.net.ServerSocket;
import java.net.Socket;

public class GerenciadorConexao {
	private GerenciadorConfiguracaoServidor configuracaoServidor;
	private GerenciadorRecebimentoMensagemCliente gerenciadorRecebimentoMensagemCliente;
	private boolean repete;

	public GerenciadorConexao(GerenciadorConfiguracaoServidor configuracaoServidor) {
		this.configuracaoServidor = configuracaoServidor;
		this.repete = true;
	}

	public boolean isRepete() {
		return repete;
	}

	public void setRepete(boolean repete) {
		this.repete = repete;
	}

	public void disponibilizaServiço() {
		try {
			ServerSocket servidor = new ServerSocket(this.configuracaoServidor.getPorta());
			System.out.println("Servidor ouvindo a porta 8080");
			
			while (this.isRepete()) {
				Socket cliente = servidor.accept();
				System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
				
				this.gerenciadorRecebimentoMensagemCliente = new GerenciadorRecebimentoMensagemCliente(cliente);
				this.gerenciadorRecebimentoMensagemCliente.receberMensagens();
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
