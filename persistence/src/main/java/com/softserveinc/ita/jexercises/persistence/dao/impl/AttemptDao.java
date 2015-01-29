package com.softserveinc.ita.jexercises.persistence.dao.impl;

import java.util.List;

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
     * Searching all attempts by user id.
     * 
     * @param id User id.
     * @return Set of user attempts if exists,null if user does not have
     *         attempts.
     */
    List<Attempt> findAllByUserId(Long id);

    /**
     * Searching all attempts by test id.
     * 
     * @param id Test id.
     * @return Set of attempts to test if exists,null if no attempts to test.
     */
    List<Attempt> findAllByTestId(Long id);
}
