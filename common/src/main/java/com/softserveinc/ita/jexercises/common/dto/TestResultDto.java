package com.softserveinc.ita.jexercises.common.dto;

import java.util.Date;
import java.util.List;

import com.softserveinc.ita.jexercises.common.utils.Role;

/**
 * Represents TestResult DTO.
 * 
 * @author Volodymyr Lishchynskiy
 * @version 1.0
 */
public class TestResultDto {
    /**
     * First name of user.
     */
    private String firstName;
    /**
     * Last name of user.
     */
    private String lastName;
    /**
     * Name of test.
     */
    private String testName;
    /**
     * Date of passing test.
     */
    private Date date;
    /**
     * List of user answers dtos.
     */
    private List<TestResultAnswerDto> answers;
    /**
     * Number of user answers.
     */
    private int totalAnswersCount;
    /**
     * Number of correct user answers.
     */
    private int correctAnswersCount;
    /**
     * Is test public or not.
     */
    private boolean isPublic;
    /**
     * Role of current user.
     */
    private Role role;

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public int getTotalAnswersCount() {
        return totalAnswersCount;
    }

    public void setTotalAnswersCount(int totalAnswersCount) {

        this.totalAnswersCount = totalAnswersCount;
    }

    public int getCorrectAnswersCount() {
        return correctAnswersCount;
    }

    public void setCorrectAnswersCount(int correctAnswersCount) {

        this.correctAnswersCount = correctAnswersCount;
    }

    public List<TestResultAnswerDto> getAnswers() {
        return answers;
    }

    public void setAnswers(List<TestResultAnswerDto> answers) {
        this.answers = answers;
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

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}