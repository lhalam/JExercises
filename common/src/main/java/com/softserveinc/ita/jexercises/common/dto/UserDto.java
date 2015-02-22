package com.softserveinc.ita.jexercises.common.dto;

import java.util.Date;
import java.util.HashSet;

/**
 * Represents User DTO.
 * 
 * @author Oksana Senchuk
 * @version 1.0
 */
public class UserDto {
    /**
     * First name of the new user.
     */
    private String firstName;
    /**
     * Last name of the new user.
     */
    private String lastName;
    /**
     * User email.
     */
    private String email;
    /**
     * User password.
     */
    private String password;
    /**
     * Password confirmation.
     */
    private String matchingPassword;

    /**
     * User date of birth.
     */
    private Date birthDate;

    /**
     * Collection of errors.
     */
    private HashSet<String> errors = new HashSet<String>();

    /**
     * Error flag.
     */
    private boolean hasErrors;

    public HashSet<String> getErrors() {
        return errors;
    }

    /**
     * Adds errors to collection.
     * 
     * @param error
     *            Error string.
     */
    public void addError(String error) {
        errors.add(error);
        if (!hasErrors) {
            hasErrors = true;
        }
    }

    public boolean getHasErrors() {
        return hasErrors;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

}
