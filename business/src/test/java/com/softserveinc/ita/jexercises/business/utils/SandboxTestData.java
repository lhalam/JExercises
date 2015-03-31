package com.softserveinc.ita.jexercises.business.utils;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Volodymyr Yakymiv
 */
@Component
public class SandboxTestData {

    private List<String> userAnswers;
    private List<String> inputData;
    private List<String> expectedData;

    public List<String> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(List<String> userAnswers) {
        this.userAnswers = userAnswers;
    }

    public List<String> getExpectedData() {
        return expectedData;
    }

    public void setExpectedData(List<String> expectedData) {
        this.expectedData = expectedData;
    }

    public List<String> getInputData() {
        return inputData;
    }

    public void setInputData(List<String> inputData) {
        this.inputData = inputData;
    }
}
