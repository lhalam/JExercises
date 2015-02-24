package com.softserveinc.ita.jexercises.common.mapper;

import com.softserveinc.ita.jexercises.common.dto.TestDescriptionDto;
import com.softserveinc.ita.jexercises.common.entity.Test;
import org.springframework.stereotype.Component;

/**
 * Represents entity/DTO mapping tool.
 *
 * @author Volodymyr Yakymiv
 * @version 1.0
 */
@Component
public class TestMapper {
    /**
     * Transforms Test entity object into TestDescription DTO object.
     *
     * @param test Test entity.
     * @return TestDescription DTO.
     */
    public TestDescriptionDto toDto(Test test) {
        TestDescriptionDto testDescriptionDto = new TestDescriptionDto();
        testDescriptionDto.setId(test.getId());
        testDescriptionDto.setName(test.getName());
        testDescriptionDto.setDescription(test.getDescription());
        return testDescriptionDto;
    }
}
