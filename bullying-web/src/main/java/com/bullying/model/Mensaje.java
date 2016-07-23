package com.bullying.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Mensaje {

	public static final String HOLA_MUNDO = "Hola mundo";
	
	@Id
    @GeneratedValue
    @Column(name = "id")
	private Long id;
	
	@Column(name = "contenido")
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
