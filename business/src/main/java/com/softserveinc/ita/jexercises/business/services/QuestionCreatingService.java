package com.softserveinc.ita.jexercises.business.services;

import com.softserveinc.ita.jexercises.common.dto.QuestionCreatingDto;
import com.softserveinc.ita.jexercises.common.entity.Assert;
import com.softserveinc.ita.jexercises.common.entity.Question;

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
     * @return Question object.
     */
    Question createQuestionDescription(QuestionCreatingDto questionCreatingDto);

    /**
     * Creating expected answer for question.
     * 
     * @param questionCreatingDto
     *            QuestionCreatingDto object.
     * @return Assert object.
     */
    Assert createExpectedAnswer(QuestionCreatingDto questionCreatingDto);

}
