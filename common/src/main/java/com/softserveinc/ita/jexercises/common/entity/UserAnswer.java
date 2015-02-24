package com.softserveinc.ita.jexercises.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Represents UserAnswer Entity.
 * 
 * @author Oleg Pavlish
 * @version 1.0
 */
@Entity
@Table(name = "USER_ANSWER")
public class UserAnswer extends BaseEntity {

    /**
     * Attempt of the answer.
     */
    @ManyToOne
    @JoinColumn(name = "ATTEMPT_ID")
    private Attempt attempt;

    /**
     * String containing user answer.
     */
    @Column(name = "ANSWER")
    private String answer;

    /**
     * Represents if the answer is correct.
     */
    @Column(name = "IS_CORRECT")
    private boolean isCorrect;

    /**
     * Answered question.
     */
    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    public Attempt getAttempt() {
        return attempt;
    }

    public void setAttempt(Attempt attempt) {
        this.attempt = attempt;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
