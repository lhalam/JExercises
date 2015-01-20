package com.softserveinc.ita.jexercises.common.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public class BaseEntity {
	
	@Id
	@GeneratedValue
	protected Long id;
	
	@Column(name = "CREATED_USER")
	@Basic(optional = false)
	protected Long createdUser;
	
	@Column(name = "MODIFIED_USER")
	@Basic(optional = false)
	protected Long modifiedUser;
	
	@Column(name = "CREATED_DATE")
	@Basic(optional = false)
	protected Date createdDate;
	
	@Column(name = "MODIFIED_DATE")
	@Basic(optional = false)
	protected Date modifiedDate;
	
	@Version
	protected Double version;
	
	public Long getId() {
		return id;
	}
	
	public Long getCreatedUser() {
		return createdUser;
	}
	
	public Long getModifiedUser() {
		return modifiedUser;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public Date getModifiedDate() {
		return modifiedDate;
	}
	
	public Double getVersion() {
		return version;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setCreatedUser(Long createdUser) {
		this.createdUser = createdUser;
	}
	
	public void setModifiedUser(Long modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	public void setVersion(Double version) {
		this.version = version;
	}
}
