package com.softserveinc.ita.jexercises.business.services;

import com.softserveinc.ita.jexercises.common.entity.Attempt;

import java.util.List;

/**
 * Service layer that calling methods of DAO layer to perform CRUD operations.
 * 
 * @author Volodymyr Lishchynskiy
 * @version 1.0
 */
public interface AttemptService {

    /**
     * Creates new attempt.
     * 
     * @param attempt New attempt.
     */
    void createAttempt(Attempt attempt);

    /**
     * Update attempt.
     * 
     * @param attempt Modified attempt.
     * @return Updated attempt.
     */
    Attempt updateAttempt(Attempt attempt);

    /**
     * Deletes attempt.
     * 
     * @param attempt Unnecessary attempt.
     */
    void deleteAttempt(Attempt attempt);

    /**
     * Deletes attempt by id.
     * 
     * @param id Id of unnecessary attempt.
     */
    void deleteAttemptById(Long id);

    /**
     * Searches attempts by id.
     * 
     * @param id Attempt id.
     * @return Attempt instance.
     */
    Attempt findAttemptById(Long id);

    /**
     * Gets all attempts.
     * 
     * @return List of attempts.
     */
    List<Attempt> findAllAttempts();

    /**
     * Gets all attempts by user id.
     * 
     * @param id User id.
     * @return List of attempts.
     */
    List<Attempt> findAllByUserId(Long id);

    /**
     * Gets all attempts by test id.
     * 
     * @param id Test id.
     * @return List of attempts.
     */
    List<Attempt> findAllByTestId(Long id);

}
