package com.softserveinc.ita.jexercises.persistence.dao.impl;

import com.softserveinc.ita.jexercises.common.entity.Question;
import com.softserveinc.ita.jexercises.persistence.dao.GenericDao;

import java.util.List;

/**
 * DAO of question.
 *
 * @author Volodymyr Yakymiv
 * @version 1.0
 */
public interface QuestionDao extends GenericDao<Question, Long> {

    /**
     * Searching all questions by test id.
     *
     * @param testId Test id.
     * @return Set of questions if exists or null if test does
     * not have any questions
     */
    List<Question> findAllByTestId(Long testId);
}
