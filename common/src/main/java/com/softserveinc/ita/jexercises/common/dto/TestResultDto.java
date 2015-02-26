package com.softserveinc.ita.jexercises.common.dto;

import java.util.List;

/**
 * Represents TestResult DTO.
 * 
 * @author Volodymyr Lishchynskiy
 * @version 1.0
 */
public class TestResultDto {    
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
}