package cliente;

import java.util.Scanner;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class GerenciadorEnvioMensagemServidor {
	private Scanner enviarMensagemServidor = new Scanner(System.in);
	private PrintStream enviarMensagem;
	
	public GerenciadorEnvioMensagemServidor (Socket cliente) throws IOException {
		this.enviarMensagem = new PrintStream(cliente.getOutputStream());
	}
	
	public void enviarMensagens () {
		while (enviarMensagemServidor.hasNextLine()) {
			enviarMensagem.println(enviarMensagemServidor.nextLine());
		}
	}
}
