package com.softserveinc.ita.jexercises.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Represents public link Entity.
 * 
 * @author Oksana Senchuk
 * @version 1.0
 */
@Entity
@Table(name = "LINK")
public class Link extends BaseEntity {
    /**
     * The id of the test.
     */
    @OneToOne
    @JoinColumn(name = "TEST_ID", nullable = false, unique = true)
    private Test test;

    /**
     * The url short code.
     */
    @Column(name = "SHORT_CODE", nullable = false, unique = true)
    private String shortCode;

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

}