package com.softserveinc.ita.jexercises.common.mapper;

import java.util.HashSet;
import java.util.Set;

import com.softserveinc.ita.jexercises.common.dto.QuestionCreatingDto;
import com.softserveinc.ita.jexercises.common.entity.Assert;

/**
 * Represents entity/DTO mapping tool.
 * 
 * @author Kucheryavenko Dmytro
 *
 * @version 1.0
 */
public class AssertMapper {
    /**
     * Transforms QuestionCreatingDto object into Set of asserts.
     * 
     * @param questionCreatingDto
     *            QuestionCreatingDto object.
     * @return Set of asserts.
     */
    public Set<Assert> toEntity(QuestionCreatingDto questionCreatingDto) {
        Assert assertVar = new Assert();
        Set<Assert> assertSet = new HashSet<>();
        assertVar.setExpectedAnswer(questionCreatingDto.getExpectedAnswer());
        assertVar.setInputData(questionCreatingDto.getInputData());
        assertSet.add(assertVar);
        return assertSet;
    }

}
