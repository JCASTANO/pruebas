package com.bullying.repository;

import com.bullying.model.Mensaje;

public interface MensajeRepository {

	public Mensaje buscarPorId(Long id);
	public Mensaje guardar(Mensaje mensaje);
	public void borrar(Mensaje mensaje);
}
