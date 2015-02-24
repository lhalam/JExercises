package com.softserveinc.ita.jexercises.common.dto;

/**
 * DTO for test result page.
 *
 * @author Volodymyr Lishchynskiy
 * @version 1.0
 */
public class TestResultAnswerDto {

    /**
     * Name of question.
     */
    private String questionName;

    /**
     * Is user answer correct or incorrect.
     */
    private boolean isCorrect;

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }
}
