package com.softserveinc.ita.jexercises.business.services;

import com.softserveinc.ita.jexercises.common.dto.TestGridDto;
import com.softserveinc.ita.jexercises.common.dto.TestGridParametersDto;

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
     * @return TestGridDto object.
     */
    TestGridDto buildTestGrid();

    /**
     * Make Parameters for TestGrid.
     *
     * @param testGridParametersDto object.
     */
    void parametriseTestGrid(TestGridParametersDto testGridParametersDto);

}
