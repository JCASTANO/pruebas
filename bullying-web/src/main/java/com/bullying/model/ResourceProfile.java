package com.bullying.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ResourceProfile 
{
	@EmbeddedId
	private ResourceProfilePk resourceProfilePk;
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false, foreignKey = @ForeignKey(name = "FK_TYPE_PROFILE"))
	private TypeProfile profile;
	@ManyToOne
	@JoinColumn(insertable = false, updatable = false, foreignKey = @ForeignKey(name = "FK_TIPO_RESOURCE"))
	private TypeResource resource;

	public TypeResource getResource() {
		return resource;
	}

	public void setResource(TypeResource resource) {
		this.resource = resource;
	}

	public TypeProfile getProfile() {
		return profile;
	}

	public void setProfile(TypeProfile profile) {
		this.profile = profile;
	}

	
}
