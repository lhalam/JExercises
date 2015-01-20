package com.softserveinc.ita.jexercises.common.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "QUESTION")
public class Question extends BaseEntity {

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Test.class)
    @JoinTable(name = "QUESTION_TEST", joinColumns = {
            @JoinColumn(name = "QUESTION_ID", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "TEST_ID",
                    nullable = false, updatable = false)})
    private Set<Test> tests;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "QUESTION")
    private Set<SharedAnswer> sharedAnswers;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "QUESTION")
    private Set<Assert> asserts;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "QUESTION")
    private Set<UserAnswer> userAnswers;

    public Long getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Set<Test> getTests() {
        return tests;
    }

    public void setTests(Set<Test> tests) {
        this.tests = tests;
    }

    public Set<SharedAnswer> getSharedAnswers() {
        return sharedAnswers;
    }

    public void setSharedAnswers(Set<SharedAnswer> sharedAnswers) {
        this.sharedAnswers = sharedAnswers;
    }

    public Set<Assert> getAsserts() {
        return asserts;
    }

    public void setAsserts(Set<Assert> asserts) {
        this.asserts = asserts;
    }

    public Set<UserAnswer> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(Set<UserAnswer> userAnswers) {
        this.userAnswers = userAnswers;
    }

    public Question() {
    }

    public Question(Long id, String description) {
        super();
        this.id = id;
        this.description = description;
    }

}
