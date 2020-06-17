package br.com.pratica.model;

public class Raposa extends Animal {
	private String corPelo;

	public Raposa() {
		super();
	}

	public Raposa(String nome, String especie, String sexo, int idade, double peso, String corPelo) {
		super(nome, especie, sexo, idade, peso);
		this.corPelo = corPelo;
	}

	public String getCorPelo() {
		return corPelo;
	}

	public void setCorPelo(String corPelo) {
		this.corPelo = corPelo;
	}

	public void cacar() {
		System.out.println("");
		System.out.println("A raposa " + this.getNome() + " está caçando!");
	}

	@Override
	public void andar() {
		System.out.println("");
		System.out.println("A raposa " + this.getNome() + " está rugindo!");
	}

	@Override
	public void correr() {
		System.out.println("");
		System.out.println("A raposa " + this.getNome() + " está correndo!");
	}

	@Override
	public void comer() {
		System.out.println("");
		System.out.println("A raposa " + this.getNome() + " está comendo!");
	}

	@Override
	public void dormir() {
		System.out.println("");
		System.out.println("A raposa " + this.getNome() + " está dormindo!");
	}

	@Override
	public void brigar() {
		System.out.println("");
		System.out.println("A raposa " + this.getNome() + " está brigando!");
	}

	@Override
	public String toString() {
		return "Nome: " + this.getNome() + "\nEspecie: " + this.getEspecie() + "\nSexo: " + this.getSexo() + "\nIdade: "
				+ this.getIdade() + "\nPeso: " + this.getPeso() + "\nCor do Pelo: " + this.getCorPelo();
	}
}
