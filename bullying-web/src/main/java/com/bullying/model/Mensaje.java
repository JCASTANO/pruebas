package com.bullying.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Mensaje {
	
	@Id
	private Long id;
	
	private String contenido;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getContenido() {
		return contenido;
	}
	
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
}
