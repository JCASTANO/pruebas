package com.bullying.repository;


public interface GenericRepository {

	@SuppressWarnings("rawtypes")
	public Object buscarPorId(Class clase,Object id);
	public Object guardar(Object entity);
	public void borrar(Object entity);
}
