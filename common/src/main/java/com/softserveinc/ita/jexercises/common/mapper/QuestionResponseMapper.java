package com.softserveinc.ita.jexercises.common.mapper;

import com.softserveinc.ita.jexercises.common.dto.QuestionResponseDto;
import com.softserveinc.ita.jexercises.common.entity.Question;
import com.softserveinc.ita.jexercises.common.entity.UserAnswer;
import org.springframework.stereotype.Component;

/**
 * Represents entity mapping tool.
 *
 * @author Volodymyr Yakymiv
 * @version 1.0
 */
@Component
public class QuestionResponseMapper {

    /**
     * Sets QuestionResponse DTO object.
     *
     * @param question   Question object.
     * @param userAnswer UserAnswer object.
     * @return QuestionResponseDto DTO.
     */
    public QuestionResponseDto toDto(Question question,
                                     UserAnswer userAnswer) {
        QuestionResponseDto questionResponseDto = new QuestionResponseDto();
        questionResponseDto.setQuestionDescription(question.getDescription());
        questionResponseDto.setQuestionName(question.getName());
        questionResponseDto.setUserAnswer(userAnswer.getAnswer());
        return questionResponseDto;
    }
}
