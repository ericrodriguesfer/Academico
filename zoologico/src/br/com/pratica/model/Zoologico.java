package br.com.pratica.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Zoologico implements CrudAnimal {
	private List<Animal> animais;

	public Zoologico() {
		this.animais = new ArrayList<Animal>();
	}

	public List<Animal> getAnimais() {
		return this.animais;
	}

	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}

	public void adicionarAnimal(Animal a) {
		System.out.println("");
		try {
			this.animais.add(a);
			System.out.println("Animal adicionado com sucesso!!!");
		} catch (NullPointerException e) {
			System.out.println("Não foi possivel adicionar este animal!!!");
		}
		System.out.println("");
	}

	public void removerAnimal(Object a) {
		System.out.println("");
		try {
			this.animais.remove(a);
			System.out.println("Animal removido com sucesso!!!");
		} catch (NullPointerException e) {
			System.out.println("Não foi possivel remover este animal!!!");
		}
		System.out.println("");
	}

	public void buscarAnimal(String nome) {
		System.out.println("");
		for (Animal buscarAnimal : this.animais) {
			if (buscarAnimal.getNome().equals(nome)) {
				System.out.println(buscarAnimal);
			}
		}
		System.out.println("");
	}

	public void exibirZoologico() {
		System.out.println("");
		for (Animal exibirAnimais : this.animais) {
			System.out.println("################################");
			System.out.println(exibirAnimais);
		}
		System.out.println("");
	}

	public void exibirListaAuxiliar() {
		System.out.println("");
		for (int i = 0; i < this.animais.size(); i++) {
			System.out.println(i + "=>" + this.animais.get(i).getNome());
		}
		System.out.println("");
	}

	public void exibirLeao() {
		System.out.println("");
		for (Animal animaisExibir : animais) {
			if (animaisExibir instanceof Leao) {
				System.out.println("################################");
				System.out.println(animaisExibir);
			}
		}
		System.out.println("");
	}

	public void exibirJacare() {
		System.out.println("");
		for (Animal animaisExibir : animais) {
			if (animaisExibir instanceof Jacare) {
				System.out.println("################################");
				System.out.println(animaisExibir);
			}
		}
		System.out.println("");
	}

	public void exibirRaposa() {
		System.out.println("");
		for (Animal animaisExibir : animais) {
			if (animaisExibir instanceof Raposa) {
				System.out.println("################################");
				System.out.println(animaisExibir);
			}
		}
		System.out.println("");
	}

	public void ordenaListaIdade() {
		Collections.sort(animais);
		System.out.println("Animais ordenados com sucesso!!!");
	}

	public Animal retornaAnimal(int elemento) {
		return this.animais.get(elemento);
	}

	@Override
	public String toString() {
		return "Animais: " + this.getAnimais();
	}
}
