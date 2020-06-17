package br.com.ei.projetos.model;

import java.time.LocalDate;
import java.util.Date;

public abstract class Pessoa {

		protected String nome;
		protected LocalDate dataNascimento;
		protected Endereco endereco;
		protected String email;
		protected String cpf;
		
		public Pessoa() {}
		
		public Pessoa(String nome, LocalDate dataNascimento2, Endereco endereco, String email, String cpf) {
			super();
			this.nome = nome;
			this.dataNascimento = dataNascimento2;
			this.endereco = endereco;
			this.email = email;
			this.cpf = cpf;
		}
		
		public String getNome() {
			return this.nome;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public LocalDate getDataNascimento() {
			return this.dataNascimento;
		}
		
		public void setDataNascimento(LocalDate dataNascimento) {
			this.dataNascimento = dataNascimento;
		}
		
		public Endereco getEndereco() {
			return this.endereco;
		}
		
		public void setEndereco(Endereco endereco) {
			this.endereco = endereco;
		}
		
		public String getEmail() {
			return this.email;
		}
		
		public void setEmail(String email) {
			this.email = email;
		}
		
		public String getCpf() {
			return this.cpf;
		}
		
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		
		
		@Override
		public String toString() {
			return "Pessoa [Nome=: " + this.nome + "Data de Nascimento: " + this.dataNascimento + "Endereco: " + this.endereco + "Email: " + this.email + "Cpf: " + this.cpf
					+"]";
		}	
		
	}
