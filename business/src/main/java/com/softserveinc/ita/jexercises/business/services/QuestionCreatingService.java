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
     * @param testId of current test.
     */
    void createQuestionDescription(QuestionDto questionDto, Long testId);
}
