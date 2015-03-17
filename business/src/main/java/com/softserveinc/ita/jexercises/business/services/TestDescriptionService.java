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
     * @return TestDescriptionDto object.
     */
    TestDescriptionDto getTestDescription(Long testId);

    /**
     * Checks if user has private link.
     *
     * @param testId test id.
     * @return true if test is public or user has link for
     * private test or return  false if user does not have private link.
     */
    boolean checkDoesUserHavePrivateLink(Long testId);
}
