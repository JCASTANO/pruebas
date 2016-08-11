package com.bullying.dto;

/**
 * 
 * @author juan.castano
 *
 */
public class UserDto {
	
	private Long id;
	private String name;
	private String email;
	private Long idBullying;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getIdBullying() {
		return idBullying;
	}
	public void setIdBullying(Long idBullying) {
		this.idBullying = idBullying;
	}
	
	

}
