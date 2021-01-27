package br.com.eric.sistema.bancario.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {

	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("SistemaBancario");
	private static EntityManager entityManager = entityManagerFactory.createEntityManager();

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public static void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		Connection.entityManagerFactory = entityManagerFactory;
	}

	public static EntityManager getEntityManager() {
		return entityManager;
	}

	public static void setEntityManager(EntityManager entityManager) {
		Connection.entityManager = entityManager;
	}

}
