package com.softserveinc.ita.jexercises.common.dto;

/**
 * Represents account menu DTO.
 * 
 * @author Oksana Senchuk
 * @version 1.0
 */
public class AccountMenuDto {
    /**
     * User first name.
     */
    private String firstName;
    /**
     * User last name.
     */
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
