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
     */
    void newTest(TestCreatingDto testCreatingDto);

    /**
     * Make QuestionGrid.
     *
     * @param searchCondition
     *                  to set search conditions.
     * @return response object.
     */
    GridResponseDto<QuestionGridDto> getGridRows(SearchCondition searchCondition);


}