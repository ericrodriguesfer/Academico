package br.com.eric.sistema.bancario.controller;

import javax.persistence.Query;

import br.com.eric.sistema.bancario.connection.Connection;

public class ControllerBanco {
	
	private Connection connection;

	public ControllerBanco() {
		this.connection = new Connection();
	}

	public int totalClient() {
		String consultSqlString = "SELECT count(c.id) FROM Conta c";
		Query queryCount = this.connection.getEntityManager().createQuery(consultSqlString);
		long responseConsult = ((Number) queryCount.getSingleResult()).longValue();

		return (int) responseConsult;
	}

}
