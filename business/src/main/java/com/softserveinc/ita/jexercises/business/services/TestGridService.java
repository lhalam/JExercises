package com.softserveinc.ita.jexercises.business.services;

import com.softserveinc.ita.jexercises.common.dto.GridResponseDto;
import com.softserveinc.ita.jexercises.common.dto.SearchCondition;
import com.softserveinc.ita.jexercises.common.dto.TestGridDto;

/**
 * Service that make TestGrid.
 *
 * @author Ihor Demkovych
 * @version 1.0
 */
public interface TestGridService {

    /**
     * Make TestGrid.
     *
     * @param searchCondition
     *                  to set search conditions.
     * @return response object.
     */
    GridResponseDto<TestGridDto> getGridRows(SearchCondition searchCondition);

    /**
     * Deletes test.
     *
     * @param testId
     *             Id of unnecessary Test.
     */
    void delete(Long testId);

}
