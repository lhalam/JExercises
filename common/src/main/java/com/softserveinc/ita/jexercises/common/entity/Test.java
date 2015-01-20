package com.softserveinc.ita.jexercises.common.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "TEST")
public class Test extends BaseEntity {

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "IS_PUBLIC")
    private Boolean isPublic;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "TEST")
    private Set<Attempt> attempts;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Question.class)
    @JoinTable(name = "QUESTION_TEST", joinColumns = {
            @JoinColumn(name = "QUESTION_ID", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "TEST_ID",
                    nullable = false, updatable = false)})
    private Set<Question> questions;

    public Long getId() {
        return id;
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

    public Set<Attempt> getAttempts() {
        return attempts;
    }

    public void setAttempts(Set<Attempt> attempts) {
        this.attempts = attempts;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public Test() {

    }

    public Test(String description, Boolean isPublic) {
        super();
        this.description = description;
        this.isPublic = isPublic;

    }

}
