package com.bullying.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TypeProfile {
	
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
