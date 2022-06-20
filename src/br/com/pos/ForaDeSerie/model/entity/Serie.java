package br.com.pos.ForaDeSerie.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "serie", schema = "foradeserie")
public class Serie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSerie;
	private String nome;
	private Integer relevancia;
	private String status; // Iniciada, Assistida, Pausada, Lista 
	@Temporal(TemporalType.DATE)
	private Date dataLancamento;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario")
	private Usuario usuario;
	@ManyToOne(fetch = FetchType.EAGER, optional=true)
    @JoinColumn(name = "idGenero")
	private Genero genero;

	public Integer getIdSerie() {
		return idSerie;
	}

	public void setIdSerie(Integer idSerie) {
		this.idSerie = idSerie;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getRelevancia() {
		return relevancia;
	}

	public void setRelevancia(Integer relevancia) {
		this.relevancia = relevancia;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
}
