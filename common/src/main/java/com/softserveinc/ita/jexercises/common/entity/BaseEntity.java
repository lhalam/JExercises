package com.softserveinc.ita.jexercises.common.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Version;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "ID")
	@Basic(optional = false)
	protected Long id;
	
	@Column(name = "CREATED_USER")
	protected Long createdByUser;
	
	@Column(name = "MODIFIED_USER")
	protected Long modifiedByUser;
	
	@Column(name = "CREATED_DATE")
	protected Date createdDate;
	
	@Column(name = "MODIFIED_DATE")
	protected Date modifiedDate;
	
	@Column(name = "VERSION")
	@Version
	protected Long version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(Long createdByUser) {
		this.createdByUser = createdByUser;
	}

	public Long getModifiedByUser() {
		return modifiedByUser;
	}

	public void setModifiedByUser(Long modifiedByUser) {
		this.modifiedByUser = modifiedByUser;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
}
