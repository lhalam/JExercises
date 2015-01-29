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
import java.util.HashSet;

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
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, 
        mappedBy = "test")
    private Set<Attempt> attempts = new HashSet<Attempt>(0);

    /**
     * The set of questions.
     */
    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Question.class)
    @JoinTable(name = "QUESTION_TEST", joinColumns = {
            @JoinColumn(name = "TEST_ID", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "QUESTION_ID",
                    nullable = false, updatable = false)})
    private Set<Question> questions;

    /**
     * Constructor which provides creating of new test.
     */
    public Test() {

    }
    
    /**
     * Constructor which provides creating of new test.
     * 
     * @param description of test
     * @param isPublic status of test
     */
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
