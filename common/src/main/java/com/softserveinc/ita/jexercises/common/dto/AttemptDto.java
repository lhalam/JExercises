package com.softserveinc.ita.jexercises.common.dto;

import java.util.Date;

/**
 * Represents Attempt DTO.
 * 
 * @author Volodymyr Lishchynskiy
 * @version 1.0
 */
public class AttemptDto {

    /**
     * Date of user attempt.
     */
    private Date createdDate;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
