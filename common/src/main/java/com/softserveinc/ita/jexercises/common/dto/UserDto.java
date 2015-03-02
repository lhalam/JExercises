package com.softserveinc.ita.jexercises.common.dto;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

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
     * Datepicker's days list.
     */
    private List<Integer> days;

    /**
     * Datepicker's months list.
     */
    private HashMap<Integer, String> months;

    /**
     * Datepicker's years list.
     */
    private List<Integer> years;

    /**
     * Constructs User DTO object.
     */
    public UserDto() {
        prepareDateLists();
    }

    public List<Integer> getDays() {
        return days;
    }

    public HashMap<Integer, String> getMonths() {
        return months;
    }

    public List<Integer> getYears() {
        return years;
    }

    public HashSet<String> getErrors() {
        return errors;
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

    /**
     * Adds errors to collection.
     * 
     * @param error
     *            Error string.
     */
    public void addError(String error) {
        errors.add(error);
    }

    /**
     * Prepares lists of data for date picker.
     */
    private void prepareDateLists() {
        String[] monthsArray = new DateFormatSymbols(Locale.ENGLISH)
                .getShortMonths();
        int maxDay = 31;
        int minDay = 1;
        int minYear = 1905;
        int maxYear = 2015;
        int minMonth = 1;
        int maxMonth = 12;
        days = new ArrayList<Integer>();
        months = new LinkedHashMap<Integer, String>();
        years = new ArrayList<Integer>();
        for (int i = minDay; i <= maxDay; i++) {
            days.add(i);
        }
        for (int i = maxYear; i >= minYear; i--) {
            years.add(i);
        }
        for (int i = minMonth; i <= maxMonth; i++) {
            months.put(i, monthsArray[i - 1]);
        }
    }

}
