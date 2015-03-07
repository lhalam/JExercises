package com.softserveinc.ita.jexercises.business.services;

import com.softserveinc.ita.jexercises.common.dto.QuestionCreatingDto;

/**
 * Service that handles question creating process.
 * 
 * @author Kucheryavenko Dmytro
 *
 * @version 1.0
 */
public interface QuestionCreatingService {
    /**
     * Creating question description.
     * 
     * @param questionCreatingDto
     *            QuestionCreatingDto object.
     *
     */
    void createQuestionDescription(QuestionCreatingDto questionCreatingDto);
}
