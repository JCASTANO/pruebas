package com.bullying.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TypeProfile implements Serializable {
	
	public static final byte ID_PROFILE_GENERAL = 1;
	public static final byte ID_PROFILE_ADMINISTRADOR = 2;
	
	private static final long serialVersionUID = -1029364263101731385L;
	@Id
	private Byte idProfile;
	@Column(nullable = false)
	private String nameProfile;
	
	
	public Byte getIdProfile() {
		return idProfile;
	}
	public void setIdProfile(Byte idProfile) {
		this.idProfile = idProfile;
	}
	public String getNameProfile() {
		return nameProfile;
	}
	public void setNameProfile(String nameProfile) {
		this.nameProfile = nameProfile;
	}
	
	
	
}
