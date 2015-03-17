package com.softserveinc.ita.jexercises.common.mapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.softserveinc.ita.jexercises.common.dto.AssertDto;
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
     * Transforms List of AssertDto objects into Set of Assert objects.
     * 
     * @param assertDtoList
     *            List of AssertDto.
     * @return Set of Assert objects.
     */
    public Set<Assert> toEntitySet(List<AssertDto> assertDtoList) {
        Set<Assert> assertSet = new HashSet<>();
        AssertMapper assertMapper = new AssertMapper();
        for (AssertDto c : assertDtoList) {
            c.getExpectedAnswer();
            c.getInputData();
            assertSet.add((assertMapper.toEntity(c)));
        }

        return assertSet;

    }

    /**
     * Transforms AssertDto object into Assert entity object.
     * 
     * @param assertDto
     *            AssertDtoObject.
     * @return Assert object.
     */
    private Assert toEntity(AssertDto assertDto) {
        Assert assertVar = new Assert();
        assertVar.setExpectedAnswer(assertDto.getExpectedAnswer());
        assertVar.setInputData(assertDto.getInputData());
        return assertVar;

    }

}
