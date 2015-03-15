package com.softserveinc.ita.jexercises.common.mapper;

import com.softserveinc.ita.jexercises.common.dto.QuestionGridDto;
import com.softserveinc.ita.jexercises.common.entity.Question;
import com.softserveinc.ita.jexercises.common.utils.TextFormatter;
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
     * To set size of name field in table.
     */
    public static final int NAME = 20;

    /**
     * To set size of description field in table.
     */
    public static final int DESCRIPTION = 25;
    /**
     * Transforms Question entity object into QuestionGrid DTO object.
     *
     * @param questionList list of Question entity.
     * @return List question grid DTO.
     */
    public List<QuestionGridDto> toDto(List<Question> questionList) {
        TextFormatter textFormatter = new TextFormatter();
        List<QuestionGridDto> questionGridDtoList = new ArrayList<>();
        for (Question question : questionList) {
            QuestionGridDto questionGridDto = new QuestionGridDto();
            questionGridDto.setId(question.getId());
            questionGridDto.setName(textFormatter.setThreeDots(question.getName(),NAME));
            questionGridDto.setDescription(textFormatter.setThreeDots(question.getDescription(),DESCRIPTION));
            questionGridDtoList.add(questionGridDto);
        }

        return questionGridDtoList;
    }


}
