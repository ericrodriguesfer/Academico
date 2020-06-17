package br.com.pratica.model;

public abstract class Animal implements Comparable<Animal> {
	protected String nome;
	protected String especie;
	protected String sexo;
	protected int idade;
	protected double peso;

	public Animal() {
	}

	public Animal(String nome, String especie, String sexo, int idade, double peso) {
		super();
		this.nome = nome;
		this.especie = especie;
		this.sexo = sexo;
		this.idade = idade;
		this.peso = peso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public abstract void andar();

	public abstract void correr();

	public abstract void comer();

	public abstract void dormir();

	public abstract void brigar();

	@Override
	public int compareTo(Animal o) {
		if (this.idade < o.getIdade()) {
			return -1;
		} else if (this.idade > o.getIdade()) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Nome: " + this.getNome() + "\nEspecie: " + this.getEspecie() + "\nSexo: " + this.getSexo() + "\nIdade: "
				+ this.getIdade() + "\nPeso: " + this.getPeso();
	}
}
