package com.softserveinc.ita.jexercises.persistence.dao.impl;

import com.softserveinc.ita.jexercises.common.entity.UserAnswer;
import com.softserveinc.ita.jexercises.persistence.dao.GenericDao;

import java.util.List;

/**
 * DAO of UserAnswer.
 *
 * @author Oleg Pavlish
 * @version 1.0
 */
public interface UserAnswerDao extends GenericDao<UserAnswer, Long> {

    /**
     * Searching  user answer by question id and attempt id.
     *
     * @param questionId Question id.
     * @param attemptId Attempt id.
     * @return User Answer
     */
    UserAnswer findUserAnswerByQuestionIdAndAttemptId(Long questionId,
                                                      Long attemptId);

    /**
     * Searching all user answers answers by attempt id.
     *
     * @param attemptId Attempt Id.
     * @return Set of user answer if exists
     */
    List<UserAnswer> findAllByAttemptId(Long attemptId);
}
