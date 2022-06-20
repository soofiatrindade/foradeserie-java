package br.com.pos.ForaDeSerie.model.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.pos.ForaDeSerie.model.entity.Genero;
import br.com.pos.ForaDeSerie.model.utils.Conexao;

public class GeneroDAO {

	Conexao conexao = new Conexao();
	
	public Genero salvarGenero(Genero genero){
		EntityManager em = conexao.getConexao();
		em.getTransaction().begin();
			em.merge(genero);
		em.getTransaction().commit();
		em.close();
		return genero;
	}

	public void removerGenero(Genero genero){
		EntityManager em = conexao.getConexao();

		em.getTransaction().begin();

		/* Query query = em.createNativeQuery("delete FROM Genero g where g.idGenero= :paramIdGenero");
		query.setParameter("paramIdGenero", idGenero); */
		genero = em.merge(genero);
		em.remove(genero);
		em.getTransaction().commit();

		em.close();
	}

	
	public List<Genero> listarTodosGeneros() {
		
		List<Genero> listaResultado = new ArrayList<Genero>();
		
		EntityManager em = conexao.getConexao();
		
		em.getTransaction().begin();

		Query query = em.createQuery("SELECT g FROM Genero g order by g.nome");
						
		listaResultado.addAll(query.getResultList());

		em.getTransaction().commit();
		
		em.close();
		
		return listaResultado;
	}


	public Genero buscarGeneroById(Integer idGenero) {
		
		Genero genero;

		EntityManager em = conexao.getConexao();
		
		em.getTransaction().begin();

			try {
				genero= em.find(Genero.class, idGenero);
			} catch (Exception e) {
				genero= null;
			}

		em.getTransaction().commit();
		
		em.close();
		
		return genero;
	}
}
