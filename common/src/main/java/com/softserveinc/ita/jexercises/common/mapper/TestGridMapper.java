package com.softserveinc.ita.jexercises.common.mapper;

import com.softserveinc.ita.jexercises.common.dto.TestGridDto;
import com.softserveinc.ita.jexercises.common.entity.Test;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents entity/DTO mapping tool.
 *
 * @author Ihor Demkovych
 * @version 1.0
 */
@Component
public class TestGridMapper {
    /**
     * Transforms Test entity object into TestDescription DTO object.
     *
     * @param testList list of Test entity.
     * @return List SearchGridRows DTO.
     */
    public List<TestGridDto>  toDto(List<Test> testList) {

        List<TestGridDto> testGridDtoList = new ArrayList<>();
        for (Test test : testList) {
            TestGridDto testGridDto = new TestGridDto();
            testGridDto.setId(test.getId());
            testGridDto.setName(test.getName());
            testGridDto.setDescription(test.getDescription());
            testGridDto.setIsPublic(test.getIsPublic());
            testGridDtoList.add(testGridDto);
        }

        return testGridDtoList;
    }
}
