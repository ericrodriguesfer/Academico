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
		System.out.println("A raposa " + this.getNome() + " est� ca�ando!");
	}

	@Override
	public void andar() {
		System.out.println("");
		System.out.println("A raposa " + this.getNome() + " est� rugindo!");
	}

	@Override
	public void correr() {
		System.out.println("");
		System.out.println("A raposa " + this.getNome() + " est� correndo!");
	}

	@Override
	public void comer() {
		System.out.println("");
		System.out.println("A raposa " + this.getNome() + " est� comendo!");
	}

	@Override
	public void dormir() {
		System.out.println("");
		System.out.println("A raposa " + this.getNome() + " est� dormindo!");
	}

	@Override
	public void brigar() {
		System.out.println("");
		System.out.println("A raposa " + this.getNome() + " est� brigando!");
	}

	@Override
	public String toString() {
		return "Nome: " + this.getNome() + "\nEspecie: " + this.getEspecie() + "\nSexo: " + this.getSexo() + "\nIdade: "
				+ this.getIdade() + "\nPeso: " + this.getPeso() + "\nCor do Pelo: " + this.getCorPelo();
	}
}
