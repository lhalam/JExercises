package com.softserveinc.ita.jexercises.common.entity;

import javax.persistence.*;

@Entity
@Table
public class SharedAnswer extends BaseEntity {
	@Id
    @GeneratedValue
	private Long id;
	private String comment;
	private Long parentId;
	
	@ManyToOne
	private Question question;
	
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
