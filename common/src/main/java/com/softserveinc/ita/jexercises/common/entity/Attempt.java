package com.softserveinc.ita.jexercises.common.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEST_ID")
	private Test test;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "attempt")
	@Column(name = "USER_ANSWER_ID")
	private Set<UserAnswer> userAnswers;

	public Attempt() {
	}

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

	public Set<UserAnswer> getUserAnswers() {
		return userAnswers;
	}

	public void setUserAnswer(Set<UserAnswer> userAnswers) {
		this.userAnswers = userAnswers;
	}
}
