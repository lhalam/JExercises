package com.softserveinc.ita.jexercises.common.entity;

import javax.persistence.*;

@Entity
@Table(name = "SHARED_ANSWER")
public class SharedAnswer extends BaseEntity {
	@Id
    @GeneratedValue
    @Column(name = "SHARED_ANSWER_ID")
	private Long id;
	
	@Column(name = "COMMENT")
	private String comment;
	
	@Column(name = "PARENT_ID")
	private Long parentId;
	
	@ManyToOne
	@Column(name = "QUESTION_ID")
	private Question question;
	
	public SharedAnswer() {}
	
	public SharedAnswer(String comment, Long parentId) {
		this.comment = comment;
		this.parentId = parentId;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	

}
