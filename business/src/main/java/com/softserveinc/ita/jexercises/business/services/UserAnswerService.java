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
     * Creates new userAnswer.
     * 
     * @param userAnswer
     *            New userAnswer
     */
    void createUserAnswer(UserAnswer userAnswer);

    /**
     * Update userAnswer.
     * 
     * @param userAnswer
     *            Modified userAnswer
     * @return Updated userAnswer
     */
    UserAnswer updateUserAnswer(UserAnswer userAnswer);

    /**
     * Deletes userAnswer.
     * 
     * @param userAnswer
     *            Unnecessary userAnswer
     */
    void deleteUserAnswer(UserAnswer userAnswer);

    /**
     * Deletes userAnswer by id.
     * 
     * @param id
     *            Id of unnecessary userAnswer
     */
    void deleteUserAnswerById(Long id);

    /**
     * Searching userAnswer by id.
     * 
     * @param id
     *            Id of userAnswer
     * @return UserAnswer instance
     */
    UserAnswer findUserAnswerById(Long id);

    /**
     * Gets all userAnswers.
     * 
     * @return Set of userAnswers
     */
    List<UserAnswer> findAllUserAnswers();

    /**
     * Searching userAnswer by question id and attempt id.
     *
     * @param questionId Id of question
     * @param attemptId Id of attempt.
     * @return UserAnswer instance
     */
    UserAnswer findUserAnswerByAttemptIdAndQuestionId(Long questionId,
                                                      Long attemptId);

    /**
     * Searching all user answers by attempt id.
     *
     * @param attemptId Attempt Id.
     * @return Set of user answer if exists
     */
    List<UserAnswer> findAllByAttemptId(Long attemptId);
}
