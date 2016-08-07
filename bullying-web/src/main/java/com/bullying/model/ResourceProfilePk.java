package com.bullying.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ResourceProfilePk  implements Serializable
{
	private static final long serialVersionUID = -1491510330494547498L;

	@Column
	private Long idProfile;
	@Column
	private int idResource;

	public int getIdResource() {
		return idResource;
	}
	public void setIdResource(int idResource) {
		this.idResource = idResource;
	}
	public Long getIdProfile() {
		return idProfile;
	}
	public void setIdProfile(Long idProfile) {
		this.idProfile = idProfile;
	}
	
	

}
