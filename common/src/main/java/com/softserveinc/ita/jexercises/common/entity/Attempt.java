package com.softserveinc.ita.jexercises.common.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Represents Attempt Entity.
 * 
 * @author Volodymyr Lishchynskiy
 * @version 1.0
 */
@Entity
@Table(name = "ATTEMPT")
public class Attempt extends BaseEntity {
    /**
     * User id.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;
    /**
     * Test id.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEST_ID")
    private Test test;

    /**
     * Set of user answers.
     */
    @OneToMany(fetch = FetchType.LAZY, 
            cascade = CascadeType.ALL, mappedBy = "attempt")
    private Set<UserAnswer> userAnswers;

    /**
     * Create a new attempt.
     */
    public Attempt() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Set<UserAnswer> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswer(Set<UserAnswer> userAnswers) {
        this.userAnswers = userAnswers;
    }
}
