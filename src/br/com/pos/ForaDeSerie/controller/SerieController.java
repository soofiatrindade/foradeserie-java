package br.com.pos.ForaDeSerie.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

import br.com.pos.ForaDeSerie.model.DAO.GeneroDAO;
import br.com.pos.ForaDeSerie.model.DAO.SerieDAO;
import br.com.pos.ForaDeSerie.model.entity.Genero;
import br.com.pos.ForaDeSerie.model.entity.Serie;

@ManagedBean
@ViewScoped
public class SerieController {

	@ManagedProperty("#{usuarioController}")
	private UsuarioController loginController;

	SerieDAO daoSerie = new SerieDAO();

	Genero generoOneMenu = new Genero();

	Serie serieSelecionado = new Serie();
	String paramPesquisa;
	List<Serie> listaSeries = new ArrayList<Serie>();

	List<Genero> listaGeneros = new ArrayList<Genero>();

	public void pesquisarSeries() {
		listaSeries.clear();
		listaSeries.addAll(daoSerie.listarSeriesByNomeGeneroUsuario(getParamPesquisa(), getGeneroOneMenu(),
				loginController.getUsuario().getIdUsuario()));
	}

	public void salvarSerie() {

		serieSelecionado.setUsuario(loginController.getUsuario());
		daoSerie.salvarSerie(serieSelecionado);

		RequestContext context = RequestContext.getCurrentInstance();

		context.execute("PF('dlgDetalhesSerie').hide();");

		FacesMessage msg = new FacesMessage("Série salva com sucesso!", "INFO MSG");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, msg);

		context.update("formPesquisarSeries");
		pesquisarSeries();

	}

	public void novaSerie() {
		this.serieSelecionado = new Serie();
	}

	@PostConstruct
	public void postConstruct() {
		GeneroDAO dao = new GeneroDAO();
		listaGeneros = dao.listarTodosGeneros();
	}

	public SerieDAO getDaoSerie() {
		return daoSerie;
	}

	public void setDaoSerie(SerieDAO daoSerie) {
		this.daoSerie = daoSerie;
	}

	public Genero getGeneroOneMenu() {
		return generoOneMenu;
	}

	public void setGeneroOneMenu(Genero generoOneMenu) {
		this.generoOneMenu = generoOneMenu;
	}

	public Serie getSerieSelecionado() {
		return serieSelecionado;
	}

	public void setSerieSelecionado(Serie serieSelecionado) {
		this.serieSelecionado = serieSelecionado;
	}

	public String getParamPesquisa() {
		return paramPesquisa;
	}

	public void setParamPesquisa(String paramPesquisa) {
		this.paramPesquisa = paramPesquisa;
	}

	public List<Serie> getListaSeries() {
		return listaSeries;
	}

	public void setListaSeries(List<Serie> listaSeries) {
		this.listaSeries = listaSeries;
	}

	public UsuarioController getLoginController() {
		return loginController;
	}

	public void setLoginController(UsuarioController loginController) {
		this.loginController = loginController;
	}

	public List<Genero> getListaGeneros() {
		return listaGeneros;
	}

	public void setListaGeneros(List<Genero> listaGeneros) {
		this.listaGeneros = listaGeneros;
	}

}
