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
     * Method provides search by ID of question.
     * 
     * @param questionId
     *            question ID.
     * @return List of Assert objects.
     */
    List<Assert> findByQuestionId(Long questionId);
}
