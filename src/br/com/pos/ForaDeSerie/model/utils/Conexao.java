package br.com.pos.ForaDeSerie.model.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public final class Conexao {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("ForaDeSerie");

	public EntityManager getConexao(){ 		
	 return factory.createEntityManager();
	}
}
