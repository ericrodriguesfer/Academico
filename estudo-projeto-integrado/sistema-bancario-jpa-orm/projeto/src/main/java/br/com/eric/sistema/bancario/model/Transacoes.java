package br.com.eric.sistema.bancario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transacoes")

public class Transacoes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "matricula_conta_realizou")
	private String matriculaContaRealizou;

	@Column(name = "email_conta_realizou")
	private String emailContaRealizou;

	@Column(name = "matricula_conta_recebeu")
	private String matriculaContaRecebeu;

	@Column(name = "email_conta_recebeu")
	private String emailContaRecebeu;

	@Column(name = "valor")
	private double valor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatriculaContaRealizou() {
		return matriculaContaRealizou;
	}

	public void setMatriculaContaRealizou(String matriculaContaRealizou) {
		this.matriculaContaRealizou = matriculaContaRealizou;
	}

	public String getEmailContaRealizou() {
		return emailContaRealizou;
	}

	public void setEmailContaRealizou(String emailContaRealizou) {
		this.emailContaRealizou = emailContaRealizou;
	}

	public String getMatriculaContaRecebeu() {
		return matriculaContaRecebeu;
	}

	public void setMatriculaContaRecebeu(String matriculaContaRecebeu) {
		this.matriculaContaRecebeu = matriculaContaRecebeu;
	}

	public String getEmailContaRecebeu() {
		return emailContaRecebeu;
	}

	public void setEmailContaRecebeu(String emailContaRecebeu) {
		this.emailContaRecebeu = emailContaRecebeu;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
