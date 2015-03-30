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
     * Creates attempt and user answers objects.
     *
     * @param testId Test id.
     */
    void createAttempt(Long testId);

    /**
     * Checks if test is public.
     *
     * @param testId Id of test.
     * @return True if test is public.
     */
    boolean isPublicTest(Long testId);
}
