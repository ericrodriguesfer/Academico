package br.com.eric.sistema.bancario.controller;

import br.com.eric.sistema.bancario.connection.Connection;
import br.com.eric.sistema.bancario.model.Transacoes;

public class ControllerTransacoes {

	private Connection connection;

	public ControllerTransacoes() {
		this.connection = new Connection();
	}

	public void crateTransacao(Transacoes t) {
		this.connection.getEntityManager().getTransaction().begin();
		this.connection.getEntityManager().persist(t);
		this.connection.getEntityManager().getTransaction().commit();
	}
}
