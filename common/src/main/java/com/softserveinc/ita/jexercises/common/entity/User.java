package com.softserveinc.ita.jexercises.common.entity;

import java.util.HashSet;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User extends BaseEntity {

	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;

	@Column(name = "EMAIL", unique = true, nullable = false)
	private String email;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "AVATAR")
	private byte[] avatar;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "USER")
	private HashSet<Attempt> attempts;

	public User() {

	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public HashSet<Attempt> getAttempts() {
		return attempts;
	}

	public void setAttempts(HashSet<Attempt> attempts) {
		this.attempts = attempts;
	}

}
