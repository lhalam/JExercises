package com.softserveinc.ita.jexercises.business.services;

import com.softserveinc.ita.jexercises.common.dto.TestDescriptionDto;

/**
 * Service that make TestDescription.
 *
 * @author Volodymyr Yakymiv
 * @version 1.0
 */
public interface TestDescriptionService {
    /**
     * Make TestDescription.
     *
     * @param testId Id of test.
     *
     * @return TestDescriptionDto object.
     */
    TestDescriptionDto getTestDescription(Long testId);
}
