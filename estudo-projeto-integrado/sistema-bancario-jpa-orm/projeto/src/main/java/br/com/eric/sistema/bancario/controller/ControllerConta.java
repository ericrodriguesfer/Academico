package br.com.eric.sistema.bancario.controller;

import javax.persistence.TypedQuery;

import java.util.List;
import br.com.eric.sistema.bancario.connection.Connection;
import br.com.eric.sistema.bancario.model.Conta;

public class ControllerConta {
	
	private Connection connection;

	public ControllerConta() {
		this.connection = new Connection();
	}

	public void createConta(Conta conta) {
		this.connection.getEntityManager().getTransaction().begin();
		this.connection.getEntityManager().persist(conta);
		this.connection.getEntityManager().getTransaction().commit();
	}

	public List<Conta> listContas() {
		String sql = "SELECT c FROM Conta c";
		TypedQuery<Conta> queryContas = this.connection.getEntityManager().createQuery(sql, Conta.class);
		List<Conta> contas = queryContas.getResultList();

		return contas;
	}

	public void depositoConta(Conta c) {
		this.connection.getEntityManager().getTransaction().begin();
		this.connection.getEntityManager().merge(c);
		this.connection.getEntityManager().getTransaction().commit();
	}

	public void saqueConta(Conta c) {
		this.connection.getEntityManager().getTransaction().begin();
		this.connection.getEntityManager().merge(c);
		this.connection.getEntityManager().getTransaction().commit();
	}

}
