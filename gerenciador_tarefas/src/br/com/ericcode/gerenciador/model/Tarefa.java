package br.com.ericcode.gerenciador.model;

public class Tarefa {
	private String titulo;
	private String acao;
	private boolean realizada;
	
	public Tarefa() {}

	public Tarefa(String titulo, String acao) {
		this.titulo = titulo;
		this.acao = acao;
		this.realizada = false;
	}
	
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAcao() {
		return this.acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public boolean isRealizada() {
		return realizada;
	}

	public void setRealizada(boolean realizada) {
		this.realizada = realizada;
	}

	@Override
	public String toString() {
		//return "Titulo: " + this.getTitulo();
		return "Titulo: " + this.getTitulo() + "\nAçao: " + this.getAcao() + "\nRealizada: " + this.isRealizada() + "\n";
	}
}
