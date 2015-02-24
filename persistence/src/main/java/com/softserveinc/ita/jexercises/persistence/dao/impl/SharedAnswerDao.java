package com.softserveinc.ita.jexercises.persistence.dao.impl;

import java.util.List;

import com.softserveinc.ita.jexercises.common.entity.SharedAnswer;
import com.softserveinc.ita.jexercises.persistence.dao.GenericDao;

/**
 * DAO of sharedAnswer.
 * 
 * @author Oleg Pavlish
 * @version 1.0
 */
public interface SharedAnswerDao extends GenericDao<SharedAnswer, Long> {

    /**
     * Searching all sharedAnswers by question id.
     * 
     * @param questionId
     *            Question id
     * @return Set of userAnswers if exist <b>or</b>
     *         <p>
     *         <i>null</i> if question wasn't answered yet
     */
    List<SharedAnswer> findAllByQuestionId(Long questionId);

}
