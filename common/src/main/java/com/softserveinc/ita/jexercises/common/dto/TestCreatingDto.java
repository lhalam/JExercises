package com.softserveinc.ita.jexercises.common.dto;

/**
 * Class represents question creating DTO.
 *
 * @author Ihor Demkovych
 *
 * @version 1.0
 */
public class TestCreatingDto {
    /**
     * ID of the test.
     */
    private Long testId;
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
     * Link to test.
     */
    private String testUrl;

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

    public Long getTestId() { return testId; }

    public void setTestId(Long testId) { this.testId = testId; }

    public String getTestUrl() { return testUrl; }

    public void setTestUrl(String testUrl) { this.testUrl = testUrl; }
}
