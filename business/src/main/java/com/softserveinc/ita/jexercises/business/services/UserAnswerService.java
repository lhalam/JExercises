package com.softserveinc.ita.jexercises.business.services;

import java.util.List;

import com.softserveinc.ita.jexercises.common.entity.UserAnswer;

/**
 * Service layer that calling methods of DAO layer to perform CRUD operations.
 * 
 * @author Oleg Pavlish
 * @version 1.0
 */
public interface UserAnswerService {

    /**
     * Creates new userAnswer
     * 
     * @param userAnswer
     *            New userAnswer
     */
    void createUserAnswer(UserAnswer userAnswer);

    /**
     * Update userAnswer
     * 
     * @param userAnswer
     *            Modified userAnswer
     * @return Updated userAnswer
     */
    UserAnswer updateUserAnswer(UserAnswer userAnswer);

    /**
     * Deletes userAnswer
     * 
     * @param userAnswer
     *            Unnecessary userAnswer
     */
    void deleteUserAnswer(UserAnswer userAnswer);

    /**
     * Deletes userAnswer by id
     * 
     * @param id
     *            Id of unnecessary userAnswer
     */
    void deleteUserAnswerById(Long id);

    /**
     * Searching userAnswer by id
     * 
     * @param id
     *            Id of userAnswer
     * @return UserAnswer instance
     */
    UserAnswer findUserAnswerById(Long id);

    /**
     * Gets all userAnswers
     * 
     * @return Set of userAnswers
     */
    List<UserAnswer> findAllUserAnswers();

    /**
     * Gets all userAnswers by test id
     * 
     * @param testId
     *            Id of test
     * @return Set of userAnswers
     */
    List<UserAnswer> findAllUserAnswersByAttemptId(Long testId);

    /**
     * Gets all userAnswers by question id
     * 
     * @param questionId
     *            Id of question
     * @return Set of userAnswers
     */
    List<UserAnswer> findAllUserAnswersByQuestionId(Long questionId);
}
