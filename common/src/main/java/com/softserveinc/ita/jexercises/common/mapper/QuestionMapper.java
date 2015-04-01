package com.softserveinc.ita.jexercises.common.mapper;

import com.softserveinc.ita.jexercises.common.dto.QuestionDto;
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
     * Transforms QuestionDto object intoQuestion object.
     * 
     * @param questionDto
     *            QuestionDto object.
     * @return Question object.
     */
    public Question toEntity(QuestionDto questionDto) {
        Question question = new Question();
        question.setDescription(questionDto.getQuestionDescription());
        question.setName(questionDto.getQuestionName());

        return question;
    }

    /**
     * Transforms QuestionDto object intoQuestion object.
     * 
     * @param question
     *            Question object.
     * @param questionDto
     *            QuestionDto object.
     * @return Question object.
     */
    public Question toEntity(Question question, QuestionDto questionDto) {
        question.setDescription(questionDto.getQuestionDescription());
        question.setName(questionDto.getQuestionName());
        return question;
    }

    /**
     * Transforms Question object into QuestionDto object.
     * 
     * @param question
     *            object.
     * @return QuestionDto object.
     */
    public QuestionDto toDto(Question question) {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionName(question.getName());
        questionDto.setQuestionDescription(question.getDescription());
        return questionDto;

    }
}
