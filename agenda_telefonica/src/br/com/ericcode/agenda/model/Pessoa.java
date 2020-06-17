package br.com.ericcode.agenda.model;

public class Pessoa {
	private String nome;
	private String sobreNome;
	private String apelido;
	private int idade;
	
	public Pessoa() {}

	public Pessoa(String nome, String sobreNome, String apelido, int idade) {
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.apelido = apelido;
		this.idade = idade;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return this.sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getApelido() {
		return this.apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public int getIdade() {
		return this.idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Nome: " + this.getNome() + "\nSobrenome: " + this.getSobreNome() + "\nApelido: " + this.getApelido() + "\nIdade: " + this.getIdade();
	}
}
