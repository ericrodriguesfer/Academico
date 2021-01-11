package servidor;

public class GerenciadorConfiguracaoServidor {
	private int porta;
	
	public GerenciadorConfiguracaoServidor(int porta){
		this.porta = porta;
	}
	
	public int getPorta(){
		return this.porta;
	}
}
