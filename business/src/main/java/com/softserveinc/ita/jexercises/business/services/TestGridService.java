package com.softserveinc.ita.jexercises.business.services;

import com.softserveinc.ita.jexercises.common.dto.SearchParametersDto;
import com.softserveinc.ita.jexercises.common.dto.SearchGridDto;

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
     * @param searchParametersDto
     *                  to set search conditions.
     * @return TestGridDto object.
     */
    SearchGridDto buildTestGrid(SearchParametersDto
        searchParametersDto);

}
