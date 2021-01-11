package servidor;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class GerenciadorRecebimentoMensagemCliente {
	private Scanner recebidoCliente;
	
	public GerenciadorRecebimentoMensagemCliente (Socket cliente) throws IOException {
		this.recebidoCliente = new Scanner(cliente.getInputStream());
	}
	
	public void receberMensagens () {
		while (recebidoCliente.hasNextLine()) {
			System.out.println("Cliente: " + recebidoCliente.nextLine());
		}
	}
}
