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
import java.util.List;

/**
 * Represents Test Entity.
 *
 * @author Ihor Demkovych
 * @version 1.0
 */
@Entity
@Table(name = "TEST")
public class Test extends BaseEntity {

    /**
     * Name of the test.
     */
    @Column(name = "NAME")
    private String name;
    /**
     * Description of the test.
     */
    @Column(name = "DESCRIPTION")
    private String description;

    /**
     * Public status of the test.
     */
    @Column(name = "IS_PUBLIC")
    private Boolean isPublic;

    /**
     * The set of attempts.
     */
    @Column(name = "ATTEMPT_ID")
    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, mappedBy = "test")
    private List<Attempt> attempts;

    /**
     * The set of questions.
     */
    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Question.class)
    @JoinTable(name = "QUESTION_TEST",
            joinColumns = {@JoinColumn(name = "TEST_ID",
                    nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "QUESTION_ID",
                    nullable = false, updatable = false)})
    private List<Question> questions;

    /**
     * Constructor which provides creating of new test.
     */
    public Test() {

    }

    /**
     * Constructor which provides creating of new test.
     *
     * @param name        of test
     * @param description of test
     * @param isPublic    status of test
     */
    public Test(String name, String description, Boolean isPublic) {
        this.name = name;
        this.description = description;
        this.isPublic = isPublic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public List<Attempt> getAttempts() {
        return attempts;
    }

    public void setAttempts(List<Attempt> attempts) {
        this.attempts = attempts;
    }

    public List<Question> getQuestions() {
        return this.questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}


