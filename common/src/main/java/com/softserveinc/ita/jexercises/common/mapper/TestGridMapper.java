package com.softserveinc.ita.jexercises.common.mapper;

import com.softserveinc.ita.jexercises.common.dto.TestGridDto;
import com.softserveinc.ita.jexercises.common.entity.Test;
import com.softserveinc.ita.jexercises.common.utils.TextFormatter;
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
     * To set size of name field in table.
     */
    public static final int NAME = 20;

    /**
     * To set size of description field in table.
     */
    public static final int DESCRIPTION = 25;

    /**
     * Transforms Test entity object into TestDescription DTO object.
     *
     * @param testList list of Test entity.
     * @return List SearchGridRows DTO.
     */
    public List<TestGridDto>  toDto(List<Test> testList) {
        TextFormatter textFormatter = new TextFormatter();
        List<TestGridDto> testGridDtoList = new ArrayList<>();
        for (Test test : testList) {
            TestGridDto testGridDto = new TestGridDto();
            testGridDto.setId(test.getId());
            testGridDto.setName(textFormatter.setThreeDots(test.getName(),NAME));
            testGridDto.setDescription(textFormatter.setThreeDots(
                test.getDescription(),DESCRIPTION));
            if (test.getIsPublic()) {
                testGridDto.setIsPublic("Public");
            } else {
                testGridDto.setIsPublic("Private");
            }
            testGridDtoList.add(testGridDto);
        }
        return testGridDtoList;
    }
}
