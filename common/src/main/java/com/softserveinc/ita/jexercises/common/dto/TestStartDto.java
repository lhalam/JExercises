package com.softserveinc.ita.jexercises.common.dto;

import java.util.List;

/**
 * Represents TestStart DTO.
 *
 * @author Volodymyr Yakymiv
 * @version 1.0
 */
public class TestStartDto {

    /**
     * Quantity of questions in test.
     */
    private Integer questionQuantity;

    /**
     * Id of attempt.
     */
    private Long attemptId;

    /**
     * Question description.
     */
    private String questionDescription;

    /**
     * List of questions id.
     */
    private List<Long> questionListId;

    /**
     * Question name.
     */
    private String questionName;

    public List<Long> getQuestionListId() {
        return questionListId;
    }

    public void setQuestionListId(List<Long> questionListId) {
        this.questionListId = questionListId;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public Integer getQuestionQuantity() {
        return questionQuantity;
    }

    public void setQuestionQuantity(Integer questionQuantity) {
        this.questionQuantity = questionQuantity;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    public Long getAttemptId() {
        return attemptId;
    }

    public void setAttemptId(Long attemptId) {
        this.attemptId = attemptId;
    }
}
