package com.softserveinc.ita.jexercises.common.entity;

import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "ATTEMPT")
public class Attempt extends BaseEntity {
	
	@ManyToOne
	@Column(name = "USER_ID")
	private User user;
	
	@ManyToOne (fetch = FetchType.LAZY, targetEntity = Test.class)
    @JoinColumn(name = "attempts")
	private Test test;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="attempt")
	@Column(name = "USER_ANSWER_ID")
	private HashSet<UserAnswer> userAnswer = new HashSet<UserAnswer>();
	
	public Attempt() {}
	
	public Attempt(User user, Test test) {
		this.user = user;
		this.test = test;
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
