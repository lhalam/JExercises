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

        AssertMapper assertMapper = new AssertMapper();
        question.setAsserts(assertMapper.toEntitySet(questionDto
                .getAssertDtoList()));

        return question;
    }

}
