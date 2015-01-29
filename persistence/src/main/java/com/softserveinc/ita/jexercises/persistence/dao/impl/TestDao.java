package com.softserveinc.ita.jexercises.persistence.dao.impl;

import com.softserveinc.ita.jexercises.common.entity.Test;
import com.softserveinc.ita.jexercises.persistence.dao.GenericDao;
 
import java.util.List;

/**
 * DAO of test.
 *
 * @author Ihor Demkovych
 * @version 1.0
 */
public interface TestDao extends GenericDao<Test, Long> {

    /**
     * Searching tests by question id.
     *
     * @param questionId Question id.
     * @return Set of tests if exists or null if question does
     * not have any tests
     */
    List<Test> findAllByQuestionId (Long questionId);
}
