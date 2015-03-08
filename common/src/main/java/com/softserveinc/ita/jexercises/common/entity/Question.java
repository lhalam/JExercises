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

/**
 * Represents Question Entity.
 *
 * @author Volodymyr Yakymiv
 * @version 1.0
 */
@Entity
@Table(name = "QUESTION")
public class Question extends BaseEntity {

    /**
     * Name of the question.
     */
    @Column(name = "NAME", nullable = false)
    private String name;

    /**
     * Description of the question.
     */
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    /**
     * The set of tests.
     */
    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Test.class,
            cascade = CascadeType.ALL)
    @JoinTable(name = "QUESTION_TEST", joinColumns = {
            @JoinColumn(name = "QUESTION_ID", nullable = false,
                    updatable = false) },
            inverseJoinColumns = {@JoinColumn(name = "TEST_ID",
                    nullable = false, updatable = false) })
    private Set<Test> tests;

    /**
     * The set of shared answers.
     */
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,
            mappedBy = "question")
    private Set<SharedAnswer> sharedAnswers;

    /**
     * The set of asserts.
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,
            mappedBy = "question")
    private Set<Assert> asserts;

    /**
     * The set of user answers.
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,
            mappedBy = "question")
    private Set<UserAnswer> userAnswers;

    /**
     * Default constructor which provides creating of new question.
     */
    public Question() {
    }

    /**
     * Constructor which provides creating of new question.
     *
     * @param description of question.
     */
    public Question(String description) {
        this.description = description;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}