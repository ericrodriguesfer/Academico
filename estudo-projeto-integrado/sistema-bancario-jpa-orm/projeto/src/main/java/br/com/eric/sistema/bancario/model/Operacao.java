package br.com.eric.sistema.bancario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "operacao")

public class Operacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "matricula_conta")
	private String matriculaConta;

	@Column(name = "email_conta")
	private String emailConta;

	@Column(name = "tipo")
	private Character tipo;

	@Column(name = "valor")
	private double valor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatriculaConta() {
		return matriculaConta;
	}

	public void setMatriculaConta(String matriculaConta) {
		this.matriculaConta = matriculaConta;
	}

	public String getEmailConta() {
		return emailConta;
	}

	public void setEmailConta(String emailConta) {
		this.emailConta = emailConta;
	}

	public Character getTipo() {
		return tipo;
	}

	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
