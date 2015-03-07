package com.softserveinc.ita.jexercises.common.mapper;

import com.softserveinc.ita.jexercises.common.dto.QuestionGridDto;
import com.softserveinc.ita.jexercises.common.entity.Question;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents entity/DTO mapping tool.
 *
 * @author Ihor Demkovych.
 *
 * @version 1.0
 */
@Component
public class QuestionGridMapper {
    /**
     * Transforms Question entity object into QuestionGrid DTO object.
     *
     * @param questionList list of Question entity.
     * @return List question grid DTO.
     */
    public List<QuestionGridDto> toDto(List<Question> questionList) {

        List<QuestionGridDto> questionGridDtoList = new ArrayList<>();
        for (Question question : questionList) {
            QuestionGridDto questionGridDto = new QuestionGridDto();
            questionGridDto.setId(question.getId());
            questionGridDto.setName(question.getName());
            questionGridDto.setDescription(question.getDescription());
            questionGridDtoList.add(questionGridDto);
        }

        return questionGridDtoList;
    }
}
