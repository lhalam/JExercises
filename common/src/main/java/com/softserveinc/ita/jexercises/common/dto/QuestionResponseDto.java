package com.softserveinc.ita.jexercises.common.dto;

/**
 * Represents QuestionResponse DTO.
 *
 * @author Volodymyr Yakymiv
 * @version 1.0
 */
public class QuestionResponseDto {

    /**
     * User answer.
     */
    private String userAnswer;

    /**
     * Question description.
     */
    private String questionDescription;

    /**
     * Question name.
     */
    private String questionName;

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }
}
