package br.com.ericcode.gerenciador.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String login;
	private String senha;
	private List<Tarefa> tarefas;
	
	public Usuario() {
		this.tarefas = new ArrayList<Tarefa>();
	}

	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
		this.tarefas = new ArrayList<Tarefa>();
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Tarefa> getTarefas() {
		return this.tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
	
	public void adicionarTarefa(Tarefa t) {
		System.out.println(" ");
		
		try {
			this.tarefas.add(t);
			System.out.println("Tarefa adicionada com sucesso!");
		}catch(NullPointerException e) {
			System.out.println("Erro ao cadastrar a trefa! Favor tentar novamente!");
		}
		
		System.out.println(" ");
	}
	
	public void removerTarefa(Tarefa t) {
		System.out.println(" ");
		
		try {
			this.tarefas.remove(t);
			System.out.println("Tarefa removida com sucesso!");
		}catch(NullPointerException e) {
			System.out.println("Erro ao remover a trefa! Favor tentat novamente!");
		}
		
		System.out.println(" ");
	}
	
	public void atualizarTituloTarefa(String tituloAtual, String novoTitulo) {
		for(int i = 0; i < this.tarefas.size(); i++) {
			if(this.tarefas.get(i).getTitulo().equals(tituloAtual)) {
				this.tarefas.get(i).setTitulo(novoTitulo);
			}
		}
	}
	
	public void atualizarAcaoTarefa(String titulo, String novaAcao) {
		for(int i = 0; i < this.tarefas.size(); i++) {
			if(this.tarefas.get(i).getTitulo().equals(titulo)) {
				this.tarefas.get(i).setAcao(novaAcao);
			}
		}
	}
	
	public void concluirTarefa(String titulo) {
		for(int i = 0; i < this.tarefas.size(); i++) {
			if(this.tarefas.get(i).getTitulo().equals(titulo)) {
				if(this.tarefas.get(i).isRealizada() == false) {
					this.tarefas.get(i).setRealizada(true);
					System.out.println("Tarefa realizada com sucesso!");
				}else {
					System.out.println("Tarefa já foi realizada!");
				}
			}
		}
	}
	public Tarefa retornaTarefa(int elemento) {
		return this.tarefas.get(elemento);
	}
	
	public void exibirTarefas() {
		System.out.println(" ");
		
		for(int i = 0; i < this.tarefas.size(); i++) {
			System.out.println("######## tarefa " + (i + 1) + "° ########");
			System.out.println(this.tarefas.get(i));
			System.out.println(" ");
		}
		
		System.out.println(" ");
	}
	
	public void listaAuxiliar() {
		System.out.println(" ");
		
		for(int i = 0; i < this.tarefas.size(); i++) {
			System.out.println((i + 1) + "=>" + this.tarefas.get(i).getTitulo());
		}
		
		System.out.println(" ");
	}
	
	public boolean checaTituloTarefa(String titulo) {
		for(int i = 0; i < this.tarefas.size(); i++) {
			if(this.tarefas.get(i).getTitulo().equals(titulo)) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public String toString() {
		return "Login: " + this.getLogin() + "\nSenha: " + this.getSenha() + "\n### Tarefas ###\n" + this.getTarefas();
	}
}
