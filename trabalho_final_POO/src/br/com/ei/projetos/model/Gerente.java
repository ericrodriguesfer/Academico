package br.com.ei.projetos.model;
import java.time.LocalDate;

import java.util.Date;
import java.util.Scanner;
public class Gerente extends Usuario {

	Scanner ler = new Scanner(System.in);

	public Gerente() {
		super();
	}

	public Gerente(String nome, LocalDate dataNascimento, Endereco endereco, String email, String cpf, String login,
			String senha) {
		super(nome, dataNascimento, endereco, email, cpf, login, senha);
	}	
	
	@Override
	public String toString() {
		return "Gerente [Nome: " + this.nome + "Data De Nascimento: " + this.dataNascimento + "Endereço completo: " + " Cidade: " + this.endereco.getCidade() + " Rua: " + this.endereco.getRua() + " Bairro:" +this.endereco.getBairro() + " Número: " +this.endereco.getNumero() + "Email: " + this.email + "CPF: " + this.cpf + "Login: " + this.login + "Senha: "
				+ this.senha + "Salário: " + "]";
	}

}
