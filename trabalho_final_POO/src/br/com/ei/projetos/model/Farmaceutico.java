package br.com.ei.projetos.model;

import java.time.LocalDate;
import java.util.Date;

public class Farmaceutico extends Funcionario {

	private String codigoCrf;

	public Farmaceutico() {
		super();
	}

	public Farmaceutico(String nome, LocalDate dataNascimento, Endereco endereco, String email, String cpf,
			String login, String senha, double salario, String idFuncionario, int prioridadeDeAcesso) {
		super(nome, dataNascimento, endereco, email, cpf, login, senha, salario, idFuncionario, prioridadeDeAcesso);
		this.codigoCrf = codigoCrf;
	}

	public String getCodigoCrf() {
		return this.codigoCrf;
	}

	public void setCodigoCrf(String codigoCrf) {
		this.codigoCrf = codigoCrf;
	}

	@Override
	public String toString() {
		return "Farmaceutico [Nome: " + this.nome + " Data De Nascimento: " + this.dataNascimento
				+ "Endereço completo: " + " Cidade: " + this.endereco.getCidade() + " Rua: " + this.endereco.getRua() + " Bairro:" +this.endereco.getBairro() + " Número: " +this.endereco.getNumero() + " Email: " + this.email + " CPF: " + this.cpf + " Login: " + this.login + " Senha: "
				+ this.senha + "Salário: " + this.salario + " ID do Funcionário: " + this.idFuncionario
				+ " Prioridade de Acesso: " + this.prioridadeDeAcesso + " Código CRF: " + this.codigoCrf + "]";
	}

}
