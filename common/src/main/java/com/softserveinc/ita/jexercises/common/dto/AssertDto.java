package com.softserveinc.ita.jexercises.common.dto;

/**
 * Class represents assert DTO.
 * 
 * @author Kucheryavenko Dmytro
 *
 * @version 1.0
 */
public class AssertDto {
    /**
     * Question expected answer.
     */
    private String expectedAnswer;
    /**
     * Signature of test method.
     */
    private String inputData;

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
