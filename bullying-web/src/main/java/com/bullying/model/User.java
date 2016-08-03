package com.bullying.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.bullying.util.Validator;

@Entity
public class User 
{
	public static final String PROFILE_IS_NOT_NULL = "profile is not null";
	public static final String EMAIL_IS_NOT_NULL = "email is not null";
	public static final String NAME_IS_NOT_NULL = "name is not null";
	public static final String ID_USER_IS_NOT_NULL = "idUser is not null";
	
	@Id
	private Long idUser;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String email;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_USER_TYPE_PROFILE"), name = "idProfile", nullable = false, referencedColumnName = "idProfile")
	private TypeProfile profile;	
		
	public User(Long idUser, String name, String email, TypeProfile profile) {
		setId(idUser);
		setName(name);
		setEmail(email);
		setProfile(profile);	
	}
	
	public TypeProfile getProfile() {
		return profile;
	}
	public void setProfile(TypeProfile profile) {
		Validator.validateNullEmpty(profile, PROFILE_IS_NOT_NULL);
		this.profile = profile;
	}
	public Long getId() {
		return idUser;
	}
	public void setId(Long id) {
		Validator.validateNullEmpty(id, ID_USER_IS_NOT_NULL);
		this.idUser = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		Validator.validateNullEmpty(name, NAME_IS_NOT_NULL);
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		Validator.validateNullEmpty(email, EMAIL_IS_NOT_NULL);
		this.email = email;
	}
	
}
