package br.com.ericcode.gerenciador.model;

import java.util.ArrayList;
import java.util.List;

public class Gerenciador {
	private List<Usuario> usuarios;

	public Gerenciador() {
		this.usuarios = new ArrayList<Usuario>();
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public void adicionarUsuario(Usuario u) {
		System.out.println(" ");
		
		try {
			this.usuarios.add(u);
			System.out.println("Usuario cadastrado com sucesso!");
		}catch(NullPointerException e) {
			System.out.println("Erro ao cadastrar usuario! Favor tentar novamente!");
		}
		
		System.out.println(" ");
	}
	
	public void removerUsuario(Usuario u) {
		System.out.println(" ");
		
		try {
			this.usuarios.remove(u);
			System.out.println("Usuario removiudo com sucesso!");
		}catch(NullPointerException e) {
			System.out.println("Erro ao remover usuario! Favor tentar novamente!");
		}
		
		System.out.println(" ");
	}
	
	public boolean confereCadastro(String login) {
		for(int i = 0; i < this.usuarios.size(); i++) {
			if(this.usuarios.get(i).getLogin().equals(login)) {
				return true;
			}
		}
		
		return false;
	}
	
	public void atualizarLogin(String loginAtual, String senha,String novoLogin) {
		System.out.println(" ");
		
		for(int i = 0; i < this.usuarios.size(); i++) {
			if(this.usuarios.get(i).getLogin().equals(loginAtual) && this.usuarios.get(i).getSenha().equals(senha)) {
				this.usuarios.get(i).setLogin(novoLogin);
				System.out.println("Login atualizado com sucesso!");
			}
		}
		
		System.out.println(" ");
	}
	
	public void atualizaSenha(String login, String senhaAtual, String novaSenha) {
		System.out.println(" ");
		
		for(int i = 0; i < this.usuarios.size(); i++) {
			if(this.usuarios.get(i).getLogin().equals(login) && this.usuarios.get(i).getSenha().equals(senhaAtual)) {
				this.getUsuarios().get(i).setSenha(novaSenha);
				System.out.println("Senha atualizada com sucesso!");
			}
		}
		
		System.out.println(" ");
	}
	
	public void exibirUsuarios() {
		System.out.println(" ");
		
		for(int i = 0; i < this.usuarios.size(); i++) {
			System.out.println("######## usuario " + (i + 1) +"° ########");
			System.out.println(this.getUsuarios().get(i));
			System.out.println(" ");
		}
		
		System.out.println(" ");
	}
	
	public boolean efetuarLogin(String login, String senha) {
		for(int i = 0; i < this.usuarios.size(); i++) {
			if(this.usuarios.get(i).getLogin().equals(login)) {
				if(this.usuarios.get(i).getSenha().equals(senha)) {
					return true;
				}else {
					this.erroSenha();
				}
			}else {
				this.erroLogin();
			}
		}
		
		return false;
	}
	
	public void adicionarTarefa(String login, String senha, Tarefa t) {
		System.out.println(" ");
		
		for(int i = 0; i < this.usuarios.size(); i++) {
			if(this.usuarios.get(i).getLogin().equals(login)) {
				if(this.usuarios.get(i).getSenha().equals(senha)) {
					if(this.usuarios.get(i).checaTituloTarefa(t.getTitulo()) == false) {
						this.getUsuarios().get(i).adicionarTarefa(t);						
					}else {
						this.erroTituloTarefa();
					}
				}else {
					this.erroSenha();
				}
			}else {
				this.erroLogin();
			}
		}
		
		System.out.println(" ");
	}
	
	public void removerTarefa(String login, String senha, Tarefa t) {
		System.out.println(" ");
		
		for(int i = 0; i < this.usuarios.size(); i++) {
			if(this.usuarios.get(i).getLogin().equals(login)) {
				if(this.usuarios.get(i).getSenha().equals(senha)) {
					if(this.usuarios.get(i).checaTituloTarefa(t.getTitulo()) == true) {
						this.getUsuarios().get(i).removerTarefa(t);
					}else {
						this.erroTituloTarefaRemover();
					}
				}else {
					this.erroSenha();
				}
			}else {
				this.erroLogin();
			}
		}
		
		System.out.println(" ");		
	}
	
	public void atualizarTituloTarefa(String login, String senha, String tituloAtual, String novoTitulo) {
		System.out.println(" ");
		
		for(int i = 0; i < this.usuarios.size(); i++) {
			if(this.usuarios.get(i).getLogin().equals(login)) {
				if(this.usuarios.get(i).getSenha().equals(senha)) {
					if(this.usuarios.get(i).checaTituloTarefa(tituloAtual) == true) {
						this.usuarios.get(i).atualizarTituloTarefa(tituloAtual, novoTitulo);
						System.out.println("Titulo da tarefa atualizado com sucesso!");
					}
				}else {
					this.erroSenha();
				}
			}else {
				this.erroLogin();
			}
		}
		
		System.out.println(" ");
	}
	
	public void atualizarAcaoTarefa(String login, String senha, String titulo, String novaAcao) {
		System.out.println(" ");
		
		for(int i = 0; i < this.usuarios.size(); i++) {
			if(this.usuarios.get(i).getLogin().equals(login)) {
				if(this.usuarios.get(i).getSenha().equals(senha)) {
					if(this.usuarios.get(i).checaTituloTarefa(titulo) == true) {
						this.usuarios.get(i).atualizarAcaoTarefa(titulo, novaAcao);
						System.out.println("Ação da tarefa atualizada com sucesso!");
					}
				}
			}
		}
		
		System.out.println(" ");
	}
	
	public void realizarTarefa(String login, String senha, String titulo) {
		System.out.println(" ");
		
		for(int i = 0; i < this.usuarios.size(); i++) {
			if(this.usuarios.get(i).getLogin().equals(login)) {
				if(this.usuarios.get(i).getSenha().equals(senha)) {
					if(this.usuarios.get(i).checaTituloTarefa(titulo) == true) {
						this.usuarios.get(i).concluirTarefa(titulo);
					}
				}else {
					this.erroSenha();
				}
			}else {
				this.erroLogin();
			}
		}
		
		System.out.println(" ");
	}
	
	public int quantidadeTarefas(String login) {
		for(int i = 0; i < this.usuarios.size(); i++) {
			if(this.usuarios.get(i).getLogin().equals(login)) {
				return this.usuarios.get(i).getTarefas().size();
			}
		}
		
		return -1;
	}
	
	public Tarefa retornarTarefa(String login, int elemento) {
		for(int i = 0; i < this.usuarios.size(); i++) {
			if(this.usuarios.get(i).getLogin().equals(login)) {
				return this.usuarios.get(i).retornaTarefa(elemento);
			}
		}
		
		return null;
	}
	
	public void exibirTarefas(String login) {
		for(int i = 0; i < this.usuarios.size(); i++) {
			if(this.usuarios.get(i).getLogin().equals(login)) {
				this.usuarios.get(i).exibirTarefas();
			}
		}
	}
	
	public void listaAuxiliar() {
		System.out.println(" ");
		
		for(int i = 0; i < this.usuarios.size(); i++) {
			System.out.println((i + 1) + "=>" +this.usuarios.get(i));
			System.out.println(" ");
		}
		
		System.out.println(" ");
	}
	
	public void listaAuxiliarTarefas(String login) {
		for(int i = 0; i < this.usuarios.size(); i++) {
			if(this.usuarios.get(i).getLogin().equals(login)) {
				this.usuarios.get(i).listaAuxiliar();
			}
		}
	}
	
	public Usuario retornaUsuario(int elemento) {
		return this.usuarios.get(elemento);
	}
	
	public void erroLogin() {
		System.out.println("Login de usuario não esta cadastrado!");
	}	
	
	public void erroSenha() {
		System.out.println("Senha de usuario incorreta!");
	}
	
	public void erroTituloTarefa() {
		System.out.println("Erro ao cadastrar tarefa, pois já existe uma tarefa com esse titulo! Favor tentar novamente!");
	}
	
	public void erroTituloTarefaRemover() {
		System.out.println("Erro ao remover tarefa, pois não existe uma tarefa com esse titulo! Favor tentar novamente!");
	}
	
	@Override
	public String toString() {
		return "###### Usuarios ######\n" + this.getUsuarios();
	}
}
