package br.com.ericcode.agenda.model;

public class Contato implements Comparable<Contato>{
	private String nome;
	private Pessoa pessoa;
	private Telefone telefone;
	private boolean favorito;
	
	public Contato() {
		this.pessoa = new Pessoa();
		this.telefone = new Telefone();
	}

	public Contato(String nome, Pessoa p, Telefone t) {
		this.nome = nome;
		this.pessoa = p;
		this.telefone = t;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Telefone getTelefone() {
		return this.telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public boolean isFavorito() {
		return this.favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}
	
	@Override
	public int compareTo(Contato t) {
		if(this.getPessoa().getIdade() < t.getPessoa().getIdade()) {
			return -1;
		}else if(this.getPessoa().getIdade() > t.getPessoa().getIdade()) {
			return 1;
		}
		
		return 0;
	}

	@Override
	public String toString() {
		return "Nome: " + this.getNome() + "\n######## Dados da Pessoa ########\n" + this.getPessoa() + "\n######## Dados do Telefone ########\n" + this.getTelefone() + "\nFavorito: " + this.isFavorito();
	}
}
