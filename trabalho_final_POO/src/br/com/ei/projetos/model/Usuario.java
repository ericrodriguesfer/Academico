package br.com.ei.projetos.model;

import java.time.LocalDate;

public abstract class Usuario extends Pessoa{
	
		protected String login;
		protected String senha;
		
		public Usuario(){
			super();
		}
		
		public Usuario(String nome, LocalDate dataNascimento, Endereco endereco, String email, String cpf, String login, String senha) {
			super(nome, dataNascimento, endereco, email, cpf);
			this.login = login;
			this.senha = senha;
		}
	
		public String getLogin() {
			return login;
		}
		
		public void setLogin(String login) {
			this.login = login;
		}
		
		public String getSenha() {
			return senha;
		}
		
		public void setSenha(String senha) {
			this.senha = senha;
		}

		@Override
		public String toString() {
			return "Usuario [Nome: "  + this.nome + " Data de Nascimento: " + this.dataNascimento +
					" Email: " + this.email + "CPF: " + this.cpf + " Login: " + this.login + " Senha: " + this.senha + "]";
		}

	
		
		
		
		
}
