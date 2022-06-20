package br.com.pos.ForaDeSerie.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.pos.ForaDeSerie.model.DAO.GeneroDAO;
import br.com.pos.ForaDeSerie.model.entity.Genero;

@ManagedBean
@ViewScoped
public class GeneroController {

	// DAO
	private GeneroDAO daoGenero = new GeneroDAO();
	// Atributos
	private Genero novoGenero = new Genero();
	private List<Genero> listaGenero = new ArrayList<Genero>();
	private Genero generoSelecionado = new Genero();

	@PostConstruct
	public void postConstruct() {
		listaGenero.addAll(daoGenero.listarTodosGeneros());
	}

	public void adicionarGenero() {
		daoGenero.salvarGenero(novoGenero);

		listaGenero.clear();
		listaGenero.addAll(daoGenero.listarTodosGeneros());

		FacesMessage msg = new FacesMessage("Gênero cadastrado com sucesso!", "INFO MSG");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, msg);

		novoGenero = new Genero();
	}

	public void removerGenero() {
		daoGenero.removerGenero(generoSelecionado);
		
		listaGenero.clear();
		listaGenero.addAll(daoGenero.listarTodosGeneros());

		FacesMessage msg = new FacesMessage("Gênero removido com sucesso!", "INFO MSG");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	public void alterarGenero() {

		daoGenero.salvarGenero(generoSelecionado);

		listaGenero.clear();
		listaGenero.addAll(daoGenero.listarTodosGeneros());

		FacesMessage msg = new FacesMessage("Gênero alterado com sucesso!", "INFO MSG");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	public GeneroDAO getDaoGenero() {
		return daoGenero;
	}

	public void setDaoGenero(GeneroDAO daoGenero) {
		this.daoGenero = daoGenero;
	}

	public Genero getNovoGenero() {
		return novoGenero;
	}

	public void setNovoGenero(Genero novoGenero) {
		this.novoGenero = novoGenero;
	}

	public List<Genero> getListaGenero() {
		return listaGenero;
	}

	public void setListaGenero(List<Genero> listaGenero) {
		this.listaGenero = listaGenero;
	}

	public Genero getGeneroSelecionado() {
		return generoSelecionado;
	}

	public void setGeneroSelecionado(Genero generoSelecionado) {
		this.generoSelecionado = generoSelecionado;
	}

	

}
