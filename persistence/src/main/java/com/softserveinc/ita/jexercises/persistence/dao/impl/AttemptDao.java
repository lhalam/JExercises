package com.softserveinc.ita.jexercises.persistence.dao.impl;

import com.softserveinc.ita.jexercises.common.entity.Attempt;
import com.softserveinc.ita.jexercises.persistence.dao.GenericDao;

/**
 * DAO of attempt.
 *
 * @author Volodymyr Lishchynskiy
 * @version 1.0
 */
public interface AttemptDao extends GenericDao<Attempt, Long> {

    /**
     * Searching attempt by test id and user id.
     *
     * @param testId Test id.
     * @param userId User id.
     * @return attempt object if exists,null if no attempt abject.
     */
    Attempt findAttemptByTestIdAndUserId(Long testId, Long userId);
}
