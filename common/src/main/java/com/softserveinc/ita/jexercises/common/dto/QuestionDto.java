package com.softserveinc.ita.jexercises.common.dto;

import java.util.List;

/**
 * Class represents question DTO.
 * 
 * @author Kucheryavenko Dmytro
 *
 * @version 1.0
 */
public class QuestionDto {
    /**
     * Name of the question.
     */
    private String questionName;
    /**
     * Description of the question.
     */
    private String questionDescription;
    /**
     * List of assertDto objects.
     */
    private List<AssertDto> assertDtoList;

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    public List<AssertDto> getAssertDtoList() {
        return assertDtoList;
    }

    public void setAssertDtoList(List<AssertDto> assertDtoList) {
        this.assertDtoList = assertDtoList;
    }

}
