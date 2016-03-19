package br.com.dextra.treinamento.model.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PostAudit {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String classe;

	private String metodo;
	
	private String parametro;
	
	private Date data = new Date();
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}


}
