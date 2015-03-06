package com.softserveinc.ita.jexercises.common.dto;

/**
 * Represents QuestionRequest DTO.
 *
 * @author Volodymyr Yakymiv
 * @version 1.0
 */
public class QuestionRequestDto {

    /**
     * Id of attempt.
     */
    private Long attemptId;

    /**
     * User answer.
     */
    private String userAnswer;

    /**
     * Id of current question.
     */
    private Long currentQuestionId;

    /**
     * Id of next or previous question.
     */
    private Long changeQuestionId;

    public Long getAttemptId() {
        return attemptId;
    }

    public void setAttemptId(Long attemptId) {
        this.attemptId = attemptId;
    }

    public Long getChangeQuestionId() {
        return changeQuestionId;
    }

    public void setChangeQuestionId(Long changeQuestionId) {
        this.changeQuestionId = changeQuestionId;
    }

    public Long getCurrentQuestionId() {
        return currentQuestionId;
    }

    public void setCurrentQuestionId(Long currentQuestionId) {
        this.currentQuestionId = currentQuestionId;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }
}
