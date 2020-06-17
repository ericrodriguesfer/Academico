package br.com.ericcode.agenda.model;

public class Telefone {
	private String operadora;
	private int numero;
	
	public Telefone() {}

	public Telefone(String operadora, int numero) {
		this.operadora = operadora;
		this.numero = numero;
	}

	public String getOperadora() {
		return this.operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Operadora: " + this.getOperadora() + "\nNumero: " + this.getNumero();
	}
}
