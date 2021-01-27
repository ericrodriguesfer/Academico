package br.com.eric.sistema.bancario.controller;

import br.com.eric.sistema.bancario.connection.Connection;
import br.com.eric.sistema.bancario.model.Operacao;

public class ControllerOperacao {
	
	private Connection connection;

	public ControllerOperacao() {
		this.connection = new Connection();
	}

	public void createOperacao(Operacao p) {
		this.connection.getEntityManager().getTransaction().begin();
		this.connection.getEntityManager().persist(p);
		this.connection.getEntityManager().getTransaction().commit();
	}
}
