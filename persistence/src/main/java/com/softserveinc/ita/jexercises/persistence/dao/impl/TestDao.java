package com.softserveinc.ita.jexercises.persistence.dao.impl;

import java.util.List;

import com.softserveinc.ita.jexercises.common.entity.Test;
import com.softserveinc.ita.jexercises.persistence.dao.GenericDao;

/**
 * DAO of test.
 *
 * @author Ihor Demkovych
 * @version 1.0
 */
public interface TestDao extends GenericDao<Test, Long> {

    /**
     * Adding question to test.
     *
     * @param questionId Question id.
     * @return list of tests.
     */
    List<Test> findAllByQuestionId(Long questionId);

}
