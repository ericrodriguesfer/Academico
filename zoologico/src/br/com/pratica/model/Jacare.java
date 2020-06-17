package br.com.pratica.model;

public class Jacare extends Animal {
	private double tamanho;

	public Jacare() {
		super();
	}

	public Jacare(String nome, String especie, String sexo, int idade, double peso, double tamanho) {
		super(nome, especie, sexo, idade, peso);
		this.tamanho = tamanho;
	}

	public double getTamanho() {
		return tamanho;
	}

	public void setTamanho(double tamanho) {
		this.tamanho = tamanho;
	}

	public void nadar() {
		System.out.println("");
		System.out.println("O jacar� " + this.getNome() + " est� nadando!");
	}

	@Override
	public void andar() {
		System.out.println("");
		System.out.println("O jacar� " + this.getNome() + " est� comendo!");
	}

	@Override
	public void correr() {
		System.out.println("");
		System.out.println("O jacar� " + this.getNome() + " est� comendo!");
	}

	@Override
	public void comer() {
		System.out.println("");
		System.out.println("O jacar� " + this.getNome() + " est� comendo!");
	}

	@Override
	public void dormir() {
		System.out.println("");
		System.out.println("O jacar� " + this.getNome() + " est� comendo!");
	}

	@Override
	public void brigar() {
		System.out.println("");
		System.out.println("A raposa " + this.getNome() + " est� comendo!");
	}

	@Override
	public String toString() {
		return "Nome: " + this.getNome() + "\nEspecie: " + this.getEspecie() + "\nSexo: " + this.getSexo() + "\nIdade: "
				+ this.getIdade() + "\nPeso: " + this.getPeso() + "\nTamanho: " + this.getTamanho();
	}

}
