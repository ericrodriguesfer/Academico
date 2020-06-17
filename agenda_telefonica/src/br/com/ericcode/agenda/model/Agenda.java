package br.com.ericcode.agenda.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Agenda {
	private List<Contato> contatos;

	public Agenda() {
		this.contatos = new ArrayList<Contato>();
	}

	public List<Contato> getContatos() {
		return this.contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	
	public void adicionarContato(Contato t) {
		System.out.println(" ");
		
		try {
			this.contatos.add(t);
			System.out.println("Contato adicionado com sucesso!");
		}catch(NullPointerException e) {
			System.out.println("Não foi possível adicionar este contanto! Tente novamente!");
		}
		
		System.out.println("");
	}
	
	public void removeContato(Contato t) {
		System.out.println(" ");
		
		try {
			this.contatos.remove(t);
			System.out.println("Contato removido com sucesso!");
		}catch(NullPointerException e) {
			System.out.println("Não foi possível remover este contato! Tente novamente!");
		}
		
		System.out.println(" ");
	}
	
	public void buscarContato(String nome) {
		System.out.println(" ");
		
		for(int i = 0; i < this.contatos.size(); i++) {
			if(this.contatos.get(i).getNome().equals(nome)) {
				System.out.println(this.contatos.get(i));
			}
		}
		
		System.out.println(" ");
	}
	
	public void exibirContatos() {
		System.out.println(" ");
		
		for(int i = 0; i < this.contatos.size(); i++) {
			System.out.println("############ Contato " + (i + 1) + "° ############");
			System.out.println(this.contatos.get(i));
			System.out.println(" ");
		}
		
		System.out.println(" ");
	}
	
	public void exibirFavoritos() {
		System.out.println(" ");
		int totalFavoritos = 0;
		
		for(int i = 0; i < this.contatos.size(); i++) {
			if(this.contatos.get(i).isFavorito() == true) {
				totalFavoritos++;
			}
		}
		
		if(totalFavoritos > 0) {
			for(int i = 0; i < this.contatos.size(); i++) {
				if(this.contatos.get(i).isFavorito() == true) {
					System.out.println("############ Contato " + (i + 1) + "° ############");
					System.out.println(this.contatos.get(i));
					System.out.println(" ");
				}
			}
		}else {
			System.out.println("Ainda não foi adicionado nenhum contato a lista de favoritos!");
		}

		System.out.println(" ");
	}
	
	public void ordenarContatosIdade() {
		System.out.println(" ");
		
		Collections.sort(this.contatos);
		System.out.println("Contatos ordenados pela idade!");
		
		System.out.println(" ");
	}
	
	public void listaAuxiliar() {
		System.out.println(" ");
		
		for(int i = 0; i < this.contatos.size(); i++) {
			System.out.println( (i + 1) + " => " + this.contatos.get(i).getNome());
		}
		
		System.out.println(" ");
	}
	
	public void listaAuxiliarFavoritos() {
		System.out.println(" ");
		
		for(int i = 0; i < this.contatos.size(); i++) {
			if(this.contatos.get(i).isFavorito() == true) {
				System.out.println( (i + 1) + " => " + this.contatos.get(i).getNome());
			}
		}
		
		System.out.println(" ");
	}
	
	public void tornarFavotiro(int elemento) {
		System.out.println(" ");
		
		if(this.contatos.get(elemento).isFavorito() == false) {
			this.contatos.get(elemento).setFavorito(true);
			System.out.println("Contato marcado como favorito com sucesso!");
		}else {
			System.out.println("Contato já é um favorito!");
		}
		
		System.out.println(" ");
	}
	
	public void removerFavorito(int elemento) {
		System.out.println(" ");
		
		if(this.contatos.get(elemento).isFavorito() == true) {
			this.contatos.get(elemento).setFavorito(false);
			System.out.println("Contato desmarcado como favorito com sucesso!");
		}else {
			System.out.println("Contato já não era um favorito!");
		}
		
		System.out.println(" ");
	}
	
	public boolean temFavorito() {
		for(int i = 0; i < this.contatos.size(); i++) {
			if(this.contatos.get(i).isFavorito() == true) {
				return true;
			}
		}
		
		return false;
	}
	
	public Contato retornaContato(int elemento) {
		return this.contatos.get(elemento);
	}
	
	@Override
	public String toString() {
		return "Contatos: " + this.getContatos();
	}
}
