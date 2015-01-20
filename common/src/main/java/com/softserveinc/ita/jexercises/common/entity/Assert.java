package com.softserveinc.ita.jexercises.common.entity;

import javax.persistence.*;
@Entity
@Table(name = "ASSERT")
public class Assert extends BaseEntity {
	@Column(name = "QUESTION_ID")
	private Question question;
	@Column(name = "EXPECTED_ANSWER")
	private String expectedAnswer;
	@Column(name = "INPUT_DATA")
	private String inputData;

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getExpectedAnswer() {
		return expectedAnswer;
	}

	public void setExpectedAnswer(String expectedAnswer) {
		this.expectedAnswer = expectedAnswer;
	}

	public String getInputData() {
		return inputData;
	}

	public void setInputData(String inputData) {
		this.inputData = inputData;
	}
}
