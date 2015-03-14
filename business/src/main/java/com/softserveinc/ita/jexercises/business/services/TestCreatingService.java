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
     * Make info about current test.
     *
     * @param testId of test.
     *
     * @return testCreatingDto.
     */
    TestCreatingDto infoTest(Long testId);
    /**
     * Make QuestionGrid.
     *
     * @param searchCondition
     *                  to set search conditions.
     * @return response object.
     */
    GridResponseDto<QuestionGridDto> getGridRows(SearchCondition searchCondition);

}