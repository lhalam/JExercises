package com.softserveinc.ita.jexercises.common.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Test extends BaseEntity{
	
	@Id
    @GeneratedValue
	private Long idTest;
	private String description;
	private Boolean isPublic;
	@ManyToMany
	private Attempt attempt;
	@ManyToMany
	private Set<Question> questionSet;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getIsPublic() {
		return isPublic;
	}
	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}
	public Attempt getAttempt() {
		return attempt;
	}
	public void setAttempt(Attempt attempt) {
		this.attempt = attempt;
	}

    public Set<Question> getQuestionSet() {
		return questionSet;
	}
	public void setQuestionSet(Set<Question> questionSet) {
		this.questionSet = questionSet;
	}
	public Test(String description, Boolean isPublic, Attempt attempt,
			Set questionSet) {
		super();
		this.description = description;
		this.isPublic = isPublic;
		this.attempt = attempt;
		this.questionSet = questionSet;
	}
	
	

}
