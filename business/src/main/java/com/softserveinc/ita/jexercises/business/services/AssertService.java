package com.softserveinc.ita.jexercises.business.services;

import java.util.List;

import com.softserveinc.ita.jexercises.common.entity.Assert;

/**
 * 
 * @author Kucheyavenko Dmytro
 *
 * @version 1.0
 */
public interface AssertService {

    /**
     * Create new assert.
     * 
     * @param assertVar
     *            New assert.
     */
    void createAssert(Assert assertVar);

    /**
     * Delete
     * 
     * @param assertVar
     *            Unnecessary assert.
     */
    void deleteAssert(Assert assertVar);

    /**
     * Delete Assert by id.
     * 
     * @param id
     *            Id of unnecessary assert.
     */
    void deleteAssertById(Long id);

    /**
     * 
     * @param assertVar
     *            Modified assert.
     * @return updates Assert.
     */
    Assert updateAssert(Assert assertVar);

    /**
     * 
     * @param id
     *            Find assert by id.
     * @return Assert instance.
     */
    Assert findAssertById(Long id);

    /**
     * 
     * @return List of asserts.
     */
    List<Assert> findAllAsserts();

    /**
     * 
     * @param questionId
     *            Get all asserts by question id.
     * @return List of asserts.
     */
    List<Assert> findAllByQuestionId(Long questionId);

}
