package com.softserveinc.ita.jexercises.common.entity;

import java.util.Date;

public class BaseEntity {
	protected Long id;
	protected Long createdUser;
	protected Long modifiedUser;
	protected Date createdDate;
	protected Date modifiedDate;
	protected Double version;
	
	public Long getId() {
		return this.id;
	}
	
	public Long getCreatedUser() {
		return this.createdUser;
	}
	
	public Long getModifiedUser() {
		return this.modifiedUser;
	}
	
	public Date getCreatedDate() {
		return this.createdDate;
	}
	
	public Date getModifiedDate() {
		return this.modifiedDate;
	}
	
	public Double getVersion() {
		return this.version;
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
