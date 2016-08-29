package com.bullying.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.bullying.dto.UserDto;
import com.bullying.util.Validator;

/**
 * 
 * @author juan.castano
 *
 */
@Entity
public class User 
{
	public static final String PROFILE_IS_NOT_NULL = "profile is not null";
	public static final String EMAIL_IS_NOT_NULL = "email is not null";
	public static final String NAME_IS_NOT_NULL = "name is not null";
	public static final String ID_USER_IS_NOT_NULL = "idUser is not null";
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable=false)
	private Long idUserSocial;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)	
	private String email;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_USER_TYPE_PROFILE"), name = "idProfile", nullable = false, referencedColumnName = "idProfile")
	private TypeProfile profile;	
	
	public User() {
		// Default Constructor
	}
		
	/**
	 * 
	 * @param idUserSocial
	 * @param name
	 * @param email
	 * @param profile
	 */
	public User(Long idUserSocial, String name, String email, TypeProfile profile) {
		setIdUserSocial(idUserSocial);
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
	public Long getIdUserSocial() {
		return idUserSocial;
	}
	public void setIdUserSocial(Long idUserSocial) {
		Validator.validateNullEmpty(idUserSocial, ID_USER_IS_NOT_NULL);
		this.idUserSocial = idUserSocial;
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
	public Long getId() {
		return id;
	}

	/**
	 * 
	 * @param userDto
	 * @return
	 */
	public static User createUserFromUserDto(UserDto userDto) 
	{
		User user = new User();
		user.setIdUserSocial(userDto.getId());
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());
		return user;
	}
	
}
