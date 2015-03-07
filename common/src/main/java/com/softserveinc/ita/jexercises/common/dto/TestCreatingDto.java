package com.softserveinc.ita.jexercises.common.dto;

import java.util.List;

/**
 * Class represents question creating DTO.
 *
 * @author Ihor Demkovych
 *
 * @version 1.0
 */
public class TestCreatingDto {
    /**
     * Name of the test.
     */
    private String testName;
    /**
     * Description of the test.
     */
    private String testDescription;
    /**
     * Availability of test.
     */
    private boolean isPublic;
    /**
     * List off qeustion id.
     */
    private List<Long> questionsId;

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestDescription() {
        return testDescription;
    }

    public void setTestDescription(String testDescription) {
        this.testDescription = testDescription;
    }

    public boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public List<Long> getQuestionsId() {
        return questionsId;
    }

    public void setQuestionsId(List<Long> questionsId) {
        this.questionsId = questionsId;
    }


}
