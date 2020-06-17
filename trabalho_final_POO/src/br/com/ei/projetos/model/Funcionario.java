package br.com.ei.projetos.model;

import java.time.LocalDate;
import java.util.Date;

public abstract class Funcionario extends Usuario{
	
	protected double salario;
	protected String idFuncionario;
	protected int prioridadeDeAcesso;
	
	public Funcionario() {
		super();
	}
	
	public Funcionario(String nome, LocalDate dataNascimento, Endereco endereco, String email, String cpf, String login, String senha, double salario, String idFuncionario, int prioridadeDeAcesso) {
		super(nome, dataNascimento, endereco, email, cpf, login, senha);
		this.salario = salario;
		this.idFuncionario = idFuncionario;
		this.prioridadeDeAcesso = prioridadeDeAcesso;
	}
	
	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public String getIdFuncionario() {
		return this.idFuncionario;
	}
	
	public void setIdFuncionario(String idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	
	public int getPrioridadeDeAcesso() {
		return this.prioridadeDeAcesso;
	}
	
	public void setPrioridadeDeAcesso(int prioridadeDeAcesso) {
		this.prioridadeDeAcesso = prioridadeDeAcesso;
	}
	
	

	@Override
	public String toString() {
		return "Funcionario [Nome: " + this.nome + " Data de Nascimento: " + this.dataNascimento + " Endereço: " + this.endereco
				+ " Email: " + this.email + " CPF: " + this.cpf + " Login: " + this.login + " Senha: " + this.senha + " Salario: " + this.salario
				+ " Id do Funcionario: " + this.idFuncionario + " Prioridade de Acesso: " + this.prioridadeDeAcesso + "]";
	}


	


	
	
	
}
