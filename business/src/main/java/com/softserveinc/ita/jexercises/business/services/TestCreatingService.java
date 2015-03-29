package com.softserveinc.ita.jexercises.business.services;

import com.softserveinc.ita.jexercises.common.dto.GridResponseDto;
import com.softserveinc.ita.jexercises.common.dto.QuestionGridDto;
import com.softserveinc.ita.jexercises.common.dto.SearchCondition;
import com.softserveinc.ita.jexercises.common.dto.TestCreatingDto;

/**
 * Service that make Test.
 *
 * @author Ihor Demkovych
 * @version 1.0
 */
public interface TestCreatingService {

    /**
     * Make new test.
     *
     * @param testCreatingDto
     *                  to set fields of new test.
     * @return testId of created test.
     */
    Long createTest(TestCreatingDto testCreatingDto);

    /**
     * Updates test.
     *
     * @param testCreatingDto
     *                  to set fields of new test.
     * @param testId to set existing test.
     * @return testId of created test.
     */
    Long updateTest(TestCreatingDto testCreatingDto, Long testId);

    /**
     * Make info about current test.
     *
     * @param testId of test.
     *
     * @return testCreatingDto.
     */
    TestCreatingDto infoTest(Long testId);
    /**
     * Make QuestionGrid of all questions.
     *
     * @param searchCondition
     *                  to set search conditions.
     * @return response object.
     */
    GridResponseDto<QuestionGridDto> getGridRowsOfAllQuestions(
        SearchCondition searchCondition);

    /**
     * Make QuestionGrid of added questions.
     *
     * @param searchCondition
     *                  to set search conditions.
     * @return response object.
     */
    GridResponseDto<QuestionGridDto> getGridRowsOfAddedQuestions(
            SearchCondition searchCondition);

    /**
     * Adds Question to test.
     *
     * @param testId
     *                  to set current test.
     * @param questionId
     *                  to set question.
     */
    void addQuestion(Long questionId, Long testId);

    /**
     * Removes Question to test.
     *
     * @param testId
     *                  to set current test.
     * @param questionId
     *                  to set question.
     */
    void removeQuestion(Long questionId, Long testId);
}