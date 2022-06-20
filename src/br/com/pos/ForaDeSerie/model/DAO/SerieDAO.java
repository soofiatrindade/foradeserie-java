package br.com.pos.ForaDeSerie.model.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.pos.ForaDeSerie.model.entity.Genero;
import br.com.pos.ForaDeSerie.model.entity.Serie;
import br.com.pos.ForaDeSerie.model.utils.Conexao;

public class SerieDAO {
	Conexao conexao = new Conexao();

	@SuppressWarnings("unchecked")
	public List<Serie> listarSeriesByNomeGeneroUsuario(String paramPesquisa, Genero genero, Integer idUsuario) {
		List<Serie> listaResultado = new ArrayList<Serie>();

		EntityManager em = conexao.getConexao();

		em.getTransaction().begin();

		String pesquisa = "";

		pesquisa = "SELECT s FROM Serie s where s.nome like :paramPesquisa and s.usuario.idUsuario = :paramUsuario";

		if (genero != null && genero.getIdGenero() != null) {
			pesquisa = pesquisa + " and s.genero.idGenero = :paramGenero";
		}
		pesquisa += " order by s.relevancia desc";
		Query query = em.createQuery(pesquisa);
		query.setParameter("paramPesquisa", "%" + paramPesquisa + "%");
		query.setParameter("paramUsuario", idUsuario);

		if (genero != null && genero.getIdGenero() != null) {
			query.setParameter("paramGenero", genero.getIdGenero());
		}

		listaResultado.addAll(query.getResultList());

		em.getTransaction().commit();

		em.close();

		return listaResultado;
	}

	public Serie salvarSerie(Serie serie) {
		EntityManager em = conexao.getConexao();

		em.getTransaction().begin();

		em.merge(serie);

		em.getTransaction().commit();

		em.close();

		return serie;
	}
}
