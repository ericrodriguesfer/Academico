package br.com.pratica.model;

public class Leao extends Animal {
	private boolean juba;

	public Leao() {
		super();
	}

	public Leao(String nome, String especie, String sexo, int idade, double peso, boolean juba) {
		super(nome, especie, sexo, idade, peso);
		this.juba = juba;
	}

	public boolean isJuba() {
		return juba;
	}

	public void setJuba(boolean juba) {
		this.juba = juba;
	}

	public void rugir() {
		System.out.println("");
		System.out.println("O leão " + this.getNome() + " está rugindo!");
	}

	@Override
	public void andar() {
		System.out.println("");
		System.out.println("O leão " + this.getNome() + " está andando!");
	}

	@Override
	public void correr() {
		System.out.println("");
		System.out.println("O leão " + this.getNome() + " está correndo!");
	}

	@Override
	public void comer() {
		System.out.println("");
		System.out.println("O leão " + this.getNome() + " está correndo!");
	}

	@Override
	public void dormir() {
		System.out.println("");
		System.out.println("O leão " + this.getNome() + " está dormindo!");
	}

	@Override
	public void brigar() {
		System.out.println("");
		System.out.println("O leão " + this.getNome() + " está brigando!");
	}

	@Override
	public String toString() {
		return "Nome: " + this.getNome() + "\nEspecie: " + this.getEspecie() + "\nSexo: " + this.getSexo() + "\nIdade: "
				+ this.getIdade() + "\nPeso: " + this.getPeso() + "\nJuba: " + this.isJuba();
	}
}
