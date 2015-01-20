package com.softserveinc.ita.jexercises.common.entity;

import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Basic;


@Entity
@Table(name = "ATTEMPT")
public class Attempt extends BaseEntity {
	@Id
    @GeneratedValue
    @Column(name = "ATTEMPT_ID")
	@Basic(optional = false)
	private Long id;
	
	@ManyToOne
	@Column(name = "USER_ID")
	private User user;
	
	@Column(name = "TEST_ID")
	private Test test;
	
	@OneToMany(mappedBy="attempt")
	@Column(name = "USER_ANSWER_ID")
	private HashSet<UserAnswer> userAnswer = new HashSet<UserAnswer>();
	
	public Attempt() {}
	
	public Attempt(User user, Test test) {
		this.user = user;
		this.test = test;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public HashSet<UserAnswer> getUserAnswer() {
		return userAnswer;
	}
	public void setUserAnswer(HashSet<UserAnswer> userAnswer) {
		this.userAnswer = userAnswer;
	}

}
