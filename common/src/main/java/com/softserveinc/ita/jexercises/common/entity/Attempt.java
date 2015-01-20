package com.softserveinc.ita.jexercises.common.entity;

import java.util.HashSet;

import javax.persistence.*;

@Entity
@Table
public class Attempt extends BaseEntity {
	@Id
    @GeneratedValue
	private Long id;
	
	@ManyToOne
	private User user;
	private Test test;
	
	@OneToMany(mappedBy="attempt",cascade=CascadeType.PERSIST)
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
