package com.bullying.dto;

public class Mensaje {
	
	public static final String HOLA_MUNDO = "Hola mundo";
	
	private long id;
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
