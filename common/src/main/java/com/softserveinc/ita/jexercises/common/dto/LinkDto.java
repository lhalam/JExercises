package com.softserveinc.ita.jexercises.common.dto;

/**
 * Represents public link DTO.
 * @author Oksana
 *
 */
public class LinkDto {
    
    private Long testId;
    
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
