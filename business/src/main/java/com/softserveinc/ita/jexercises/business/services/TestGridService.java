package com.softserveinc.ita.jexercises.business.services;

import com.softserveinc.ita.jexercises.common.dto.SearchGridDto;
import com.softserveinc.ita.jexercises.common.dto.dataTables.DataTablesDto;

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
     * @param dataTablesDto
     *                  to set search conditions.
     * @return TestGridDto object.
     */
    SearchGridDto buildTestGrid(DataTablesDto dataTablesDto);

    /**
     * Deletes test.
     *
     * @param testId
     *             Id of unnecessary Test.
     */
    void delete(Long testId);

}
