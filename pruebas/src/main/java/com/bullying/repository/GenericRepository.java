package com.bullying.repository;

/**
 * 
 * @author juan.castano
 *
 */
public interface GenericRepository {

	/**
	 * 
	 * @param clase
	 * @param id
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	Object buscarPorId(Class clase,Object id);
	
	/**
	 * 
	 * @param entity
	 * @return
	 */
	Object guardar(Object entity);
}
