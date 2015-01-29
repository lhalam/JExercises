package com.softserveinc.ita.jexercises.business.services;

import com.softserveinc.ita.jexercises.common.entity.Test;

import java.util.List;

/**
 * Service layer that calling the methods of DAO layer to perform CRUD
 * operations.
 * 
 * @author Ihor Demkovych
 * @version 1.0
 */
public interface TestService {

    /**
     * Creating  test.
     * 
     * @param test New test
     */
    void createTest(Test test);
    
    /**
     * Update test.
     *
     * @param test Modified test.
     * @return Updated test.
     */
    Test updateTest(Test test);

    /**
     * Deletes test.
     *
     * @param test Unnecessary test.
     */
    void deleteTest(Test test);

    /**
     * Deletes test by id.
     *
     * @param id Id of unnecessary test.
     */
    void deleteTestById(Long id);

    /**
     * Searching test by id.
     *
     * @param id Id of test.
     * @return Test instance.
     */
    Test findTestById(Long id);

    /**
     * Gets all tests.
     *
     * @return Set of tests.
     */
    List<Test> findAllTests();

    /**
     * Gets all tests by question id.
     *
     * @param questionId Id of question.
     * @return Set of tests.
     */
    List<Test> findAllTestsByQuestionId(Long questionId);
}
