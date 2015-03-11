package com.softserveinc.ita.jexercises.common.dto;

import java.util.Date;

/**
 * Data Transfer Object used to return set of attempts to DataTables.
 *
 * @author Taras Vuyiv.
 */
public class AttemptDto {
    private Long id;
    private String testName;
    private Date createdDate;
    private String result;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date date) {
        this.createdDate = date;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }
}
