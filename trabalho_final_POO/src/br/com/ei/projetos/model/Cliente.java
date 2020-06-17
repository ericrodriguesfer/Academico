package br.com.ei.projetos.model;

import java.time.LocalDate;
import java.util.Date;

public class Cliente extends Usuario{
		
	public Cliente() {}
	
	public Cliente(String nome, LocalDate dataNascimento, Endereco endereco, String email, String cpf, String login, String senha) {
		super(nome, dataNascimento, endereco, email, cpf, login, senha);
	}
	

	@Override
	public String toString() {
		return "Cliente [Nome: " + this.nome + " Data de Nascimento: " + this.dataNascimento + " Email: "
				+ this.email + " Cpf: " + this.cpf + " Login: " + this.login + " Senha: " + this.senha +  
				"Endereço completo: " + " Cidade: " + this.endereco.getCidade() + " Rua: " + this.endereco.getRua() + " Bairro:" +this.endereco.getBairro() + " Número: " +this.endereco.getNumero() + "]";
	}
	
}
