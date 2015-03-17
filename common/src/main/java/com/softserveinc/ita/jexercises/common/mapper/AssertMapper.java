package com.softserveinc.ita.jexercises.common.mapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.softserveinc.ita.jexercises.common.dto.AssertDto;
import com.softserveinc.ita.jexercises.common.dto.QuestionDto;
import com.softserveinc.ita.jexercises.common.entity.Assert;
import com.softserveinc.ita.jexercises.common.entity.Question;

/**
 * Represents entity/DTO mapping tool.
 * 
 * @author Kucheryavenko Dmytro
 *
 * @version 1.0
 */
public class AssertMapper {
    /**
     * 
     * @param questionDto
     *            QuestionDto object.
     * @param question
     *            question object.
     * @return Set of Assert objects.
     */
    public Set<Assert> toEntitySet(QuestionDto questionDto, Question question) {
        Set<Assert> assertSet = new HashSet<>();
        List<AssertDto> assertDtoList = questionDto.getAssertDtoList();
        AssertMapper assertMapper = new AssertMapper();

        for (AssertDto c : assertDtoList) {
            c.getExpectedAnswer();
            c.getInputData();
            assertSet.add((assertMapper.toEntity(c, question)));
        }
        return assertSet;

    }

    /**
     * 
     * @param assertDto
     *            AssertDto object.
     * @param question
     *            Question object.
     * @return Assert object.
     */
    private Assert toEntity(AssertDto assertDto, Question question) {
        Assert assertVar = new Assert();
        assertVar.setExpectedAnswer(assertDto.getExpectedAnswer());
        assertVar.setInputData(assertDto.getInputData());
        assertVar.setQuestion(question);
        return assertVar;

    }

}
