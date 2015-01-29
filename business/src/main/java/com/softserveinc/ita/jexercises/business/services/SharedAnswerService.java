package com.softserveinc.ita.jexercises.business.services;

import java.util.List;

import com.softserveinc.ita.jexercises.common.entity.SharedAnswer;

/**
 * Service layer that calling methods of DAO layer to perform CRUD operations.
 * 
 * @author Oleg Pavlish
 * @version 1.0
 */
public interface SharedAnswerService {

    /**
     * Creates new sharedAnswer
     * 
     * @param sharedAnswer
     *            New sharedAnswer
     */
    void createSharedAnswer(SharedAnswer sharedAnswer);

    /**
     * Update sharedAnswer
     * 
     * @param sharedAnswer
     *            Modified sharedAnswer
     * @return Updated sharedAnswer
     */
    SharedAnswer updateSharedAnswer(SharedAnswer sharedAnswer);

    /**
     * Deletes sharedAnswer
     * 
     * @param sharedAnswer
     *            Unnecessary saredAnswer
     */
    void deleteSharedAnswer(SharedAnswer sharedAnswer);

    /**
     * Deletes sharedAnswers by id
     * 
     * @param id
     *            Id of unnecessary sharedAnswer
     */
    void deleteSharedAnswerById(Long id);

    /**
     * Searching sharedAnswer by id
     * 
     * @param id
     *            Id of sharedAnswer
     * @return SharedAnswer instance
     */
    SharedAnswer findSharedAnswerById(Long id);

    /**
     * Gets all sharedAnswers
     * 
     * @return Set of sharedAnswers
     */
    List<SharedAnswer> findAllSharedAnswers();

    /**
     * Gets all sharedAnswers by question id
     * 
     * @param questionId
     *            Id of question
     * @return Set of sharedAnswers
     */
    List<SharedAnswer> findAllSharedAnswersByQuestionId(Long questionId);
}
