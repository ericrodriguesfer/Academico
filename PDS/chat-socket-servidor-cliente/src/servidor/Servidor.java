package servidor;

public class Servidor {

	private GerenciadorConexao gerenciadorConexao;
	
	public static void main(String[] args) {
		Servidor servidor = new Servidor();
		servidor.inicia();
	}
	
	public void inicia(){
		GerenciadorConfiguracaoServidor configuracaoServidor = new GerenciadorConfiguracaoServidor(8080);
		this.gerenciadorConexao = new GerenciadorConexao(configuracaoServidor);
		this.gerenciadorConexao.disponibilizaServiço();
	}
}
