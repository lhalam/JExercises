package com.softserveinc.ita.jexercises.persistence.dao.impl;

import java.util.List;

import com.softserveinc.ita.jexercises.common.entity.Assert;
import com.softserveinc.ita.jexercises.persistence.dao.GenericDao;

/**
 * DAO of assert.
 * 
 * @author Kucheryavenko Dmytro
 *
 * @version 1.0
 */
public interface AssertDao extends GenericDao<Assert, Long> {

    /**
     * Searching all asserts by question id.
     * 
     * @param questionId
     *            question id.
     * @return Set asserts to question.
     */
    List<Assert> findAllByQuestion(Long questionId);
}
