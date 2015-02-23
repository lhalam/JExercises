package com.softserveinc.ita.jexercises.common.dto;

/**
 * Class represents user dto.
 * 
 * @author Kucheryavenko Dmytro
 *
 * @version 1.0
 */
public class QuestionCreatingDto {
    /**
     * Name of the question.
     */
    private String questionName;
    /**
     * Description of the question.
     */
    private String questionDescription;
    /**
     * Expected question answer.
     */
    private String expectedAnswer;
    /**
     * Signature of the test method
     */
    private String inputData;
    
    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
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

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }
}
