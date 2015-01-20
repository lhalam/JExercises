package com.softserveinc.ita.jexercises.common.entity;

import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User extends BaseEntity {
	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private Long id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "AVATAR")
	private byte[] avatar;

	@Column(name = "FIRST_NAME")
	@OneToMany(mappedBy = "USER")
	private HashSet<Attempt> attempts;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

	public HashSet<Attempt> getAttempts() {
		return attempts;
	}

	public void setAttempts(HashSet<Attempt> attempts) {
		this.attempts = attempts;
	}

}
