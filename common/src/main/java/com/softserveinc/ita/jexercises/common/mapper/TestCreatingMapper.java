package com.softserveinc.ita.jexercises.common.mapper;

import com.softserveinc.ita.jexercises.common.dto.TestCreatingDto;
import com.softserveinc.ita.jexercises.common.entity.Test;
import org.springframework.stereotype.Component;

/**
 * Represents DTO/entity mapping tool.
 *
 * @author Ihor Demkovych
 * @version 1.0
 */
@Component
public class TestCreatingMapper {
     /**
     * Transforms Test entity object into TestDescription DTO object.
     *
     * @param testCreatingDto Test creating Dto.
     * @return Test entity.
     */
    public Test toEntity(TestCreatingDto testCreatingDto) {
        Test test = new Test();
        test.setDescription(testCreatingDto.getTestDescription());
        test.setName(testCreatingDto.getTestName());
        test.setIsPublic(testCreatingDto.getIsPublic());
        return test;
    }


}
