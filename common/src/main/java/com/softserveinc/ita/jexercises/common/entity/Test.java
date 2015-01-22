package com.softserveinc.ita.jexercises.common.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "TEST")
public class Test extends BaseEntity {

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "IS_PUBLIC")
    private Boolean isPublic;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "test")
    private Set<Attempt> attempts;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Question.class, cascade = CascadeType.ALL)
    @JoinTable(name = "QUESTION_TEST", joinColumns = {
            @JoinColumn(name = "TEST_ID", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "QUESTION_ID",
                    nullable = false, updatable = false)})
    private Set<Question> questions;

    public Test() {
    }

    public Test(String description, Boolean isPublic) {
        this.description = description;
        this.isPublic = isPublic;
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
        return this.questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
}
