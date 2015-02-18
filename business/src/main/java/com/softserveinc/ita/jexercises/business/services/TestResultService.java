package com.softserveinc.ita.jexercises.business.services;

import com.softserveinc.ita.jexercises.common.dto.TestResultDto;

/**
 * Service for all information about result of test.
 * 
 * @author Volodymyr Lishchynskiy
 * @version 1.0
 */
public interface TestResultService {
    /**
     * Take object with all information to show on test result page.
     * 
     * @param attemptId Attempt id.
     * @return Object of TestResultDto class.
     */
    TestResultDto getTestResultInfo(long attemptId);
}
