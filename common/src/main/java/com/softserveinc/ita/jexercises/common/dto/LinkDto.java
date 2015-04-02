package com.softserveinc.ita.jexercises.common.dto;

/**
 * Represents public link DTO.
 * 
 * @author Oksana Senchuk
 * @version 1.0
 */
public class LinkDto {
    /**
     * Test id.
     */
    private Long testId;
    /**
     * Public link short code.
     */
    private String shortCode;

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

}
