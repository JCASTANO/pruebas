package com.bullying.repository;


public interface GenericRepository {

	@SuppressWarnings("rawtypes")
	Object buscarPorId(Class clase,Object id);
	Object guardar(Object entity);
}
