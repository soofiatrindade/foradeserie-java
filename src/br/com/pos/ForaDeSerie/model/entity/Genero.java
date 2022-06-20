package br.com.pos.ForaDeSerie.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "genero", schema="foradeserie")
public class Genero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	  
	private Integer idGenero;
	private String  nome;
	
	public Integer getIdGenero() {
		return idGenero;
	}
	public void setIdGenero(Integer idGenero) {
		this.idGenero = idGenero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idGenero == null) ? 0 : idGenero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genero other = (Genero) obj;
		if (idGenero == null) {
			if (other.idGenero != null)
				return false;
		} else if (!idGenero.equals(other.idGenero))
			return false;
		return true;
	}
}
