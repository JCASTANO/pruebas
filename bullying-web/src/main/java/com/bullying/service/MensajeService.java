package com.bullying.service;

import com.bullying.model.Mensaje;

public interface MensajeService {

	public Mensaje buscarPorId(Long id);
	public Mensaje guardar(Mensaje mensaje);
	public void borrar(Mensaje mensaje);
}
