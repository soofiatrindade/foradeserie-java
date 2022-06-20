package br.com.pos.ForaDeSerie.model.DAO;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.pos.ForaDeSerie.model.entity.Usuario;
import br.com.pos.ForaDeSerie.model.utils.Conexao;

public class UsuarioDAO {
	Conexao conexao = new Conexao();
	
	public Usuario validarUsuario(String login , String senha){
		
		
		Usuario usuario= null;
		
		EntityManager em = conexao.getConexao();
		
		em.getTransaction().begin();    
	    
		Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.usuario = :usuario and u.senha=:senha");
		query.setParameter("usuario", login); 
		query.setParameter("senha", senha); 
		
		try{
		  usuario = (Usuario) query.getSingleResult();
		}catch (NoResultException e) {
		  usuario = null;
		}
				
		em.getTransaction().commit();
		
		return usuario;
	}
	
	public Usuario cadastrarNovoUsuario(Usuario novoUsuario){
		
		EntityManager em = conexao.getConexao();

		em.getTransaction().begin();    
	    
			em.persist(novoUsuario);
				
		em.getTransaction().commit();
		
		return novoUsuario;
	}

	public String validarUsuario(Usuario novoUsuario) {
		EntityManager em = conexao.getConexao();
		String usuario= null;
		
		em.getTransaction().begin();    
	    
		Query query = em.createQuery("SELECT u.usuario FROM Usuario u WHERE u.usuario = :usuario");
		query.setParameter("usuario", novoUsuario.getUsuario()); 
		
		try{
		  usuario = (String) query.getSingleResult();
		}catch (NoResultException e) {
		  usuario = null;
		}
				
		em.getTransaction().commit();
		
		return usuario;
		
	}
	
	public Usuario salvarUsuario(Usuario usuario){
		
		EntityManager em = conexao.getConexao();

		em.getTransaction().begin();    
	    
			em.merge(usuario);
				
		em.getTransaction().commit();
		
		return usuario;
	}
	
}
