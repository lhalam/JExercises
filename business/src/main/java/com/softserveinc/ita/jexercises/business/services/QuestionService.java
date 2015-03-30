package com.softserveinc.ita.jexercises.business.services;

import com.softserveinc.ita.jexercises.common.entity.Question;

import java.util.List;

/**
 * Service layer that calling methods of DAO layer to perform CRUD
 * operations.
 *
 * @author Volodymyr Yakymiv
 * @version 1.0
 */
public interface QuestionService {

    /**
     * Creates new question.
     *
     * @param question New question.
     * @return ID of created question.
     */
    Long createQuestion(Question question);

    /**
     * Update question.
     *
     * @param question Modified question.
     * @return Updated question.
     */
    Question updateQuestion(Question question);

    /**
     * Deletes question.
     *
     * @param question Unnecessary question.
     */
    void deleteQuestion(Question question);

    /**
     * Deletes question by id.
     *
     * @param id Id of unnecessary question.
     */
    void deleteQuestionById(Long id);

    /**
     * Searching question by id.
     *
     * @param id Id of question.
     * @return Question instance.
     */
    Question findQuestionById(Long id);

    /**
     * Gets all questions.
     *
     * @return Set of questions.
     */
    List<Question> findAllQuestions();
}
