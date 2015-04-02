package com.softserveinc.ita.jexercises.business.services;

import com.softserveinc.ita.jexercises.common.dto.QuestionDto;

/**
 * Service that handles question creating process.
 * 
 * @author Kucheryavenko Dmytro
 *
 * @version 1.0
 */
public interface QuestionCreatingService {
    /**
     * Creating new question description.
     * 
     * @param questionDto
     *            QuestionDto object.
     * @param testId
     *            of current test.
     */
    void createQuestionDescription(QuestionDto questionDto, Long testId);

    /**
     * Method gets question description from DB.
     * 
     * @param questionId
     *            question ID.
     * @return question ID.
     */
    QuestionDto getQuestionDescription(Long questionId);

    /**
     * Method updates question.
     * 
     * @param questionDto
     *            QuestionDto object.
     * @param questionId
     *            question ID.
     */
    void updateQuestion(QuestionDto questionDto, Long questionId);
}
