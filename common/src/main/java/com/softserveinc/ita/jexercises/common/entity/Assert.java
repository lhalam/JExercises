package com.softserveinc.ita.jexercises.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Kucheryavenko Dmytro
 * @version 1.0
 */
@Entity
@Table(name = "ASSERT")
public class Assert extends BaseEntity {
    /**
     * Question id.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    /**
     * Correct answer.
     */
    @Column(name = "EXPECTED_ANSWER")
    private String expectedAnswer;

    /**
     * Data inputed by user.
     */
    @Column(name = "INPUT_DATA")
    private String inputData;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getExpectedAnswer() {
        return expectedAnswer;
    }

    public void setExpectedAnswer(String expectedAnswer) {
        this.expectedAnswer = expectedAnswer;
    }

    public String getInputData() {
        return inputData;
    }

    public void setInputData(String inputData) {
        this.inputData = inputData;
    }
}
