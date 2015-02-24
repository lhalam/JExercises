package com.softserveinc.ita.jexercises.common.mapper;

import com.softserveinc.ita.jexercises.common.dto.QuestionCreatingDto;
import com.softserveinc.ita.jexercises.common.entity.Question;

/**
 * Represents entity/DTO mapping tool.
 * 
 * @author Kucheryavenko Dmytro
 *
 * @version 1.0
 */
public class QuestionMapper {
    /**
     * Transforms QuestionCreatingDto object into Question entity object.
     * 
     * @param questionCreatingDto
     *            QuestionCreatingDto object.
     * @return Question entity object.
     */
    public Question toEntity(QuestionCreatingDto questionCreatingDto) {
        Question question = new Question();
        question.setDescription(questionCreatingDto.getQuestionDescription());
        question.setName(questionCreatingDto.getQuestionName());

        AssertMapper assertMapper = new AssertMapper();
        question.setAsserts(assertMapper.toEntity(questionCreatingDto));
        return question;
    }

}
