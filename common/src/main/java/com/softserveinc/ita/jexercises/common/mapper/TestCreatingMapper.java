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
     * Default value of URL for public test.
     */
    public static final String NO_URL = "noURL";

     /**
     * Transforms TestDescription DTO  object into Test entity object.
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

    /**
     * Transforms Test entity object into TestDescription DTO object.
     *
     * @param test is current test.
     * @return testCreatingDto.
     */
    public TestCreatingDto toDto(Test test) {
        TestCreatingDto testCreatingDto = new TestCreatingDto();
        testCreatingDto.setTestDescription(test.getDescription());
        testCreatingDto.setTestName(test.getName());
        testCreatingDto.setIsPublic(test.getIsPublic());
        testCreatingDto.setTestId(test.getId());
        if (test.getIsPublic()) {
            testCreatingDto.setTestUrl(NO_URL);
        } else {
            testCreatingDto.setTestUrl(test.getLink().getShortCode());
        }
        return testCreatingDto;
    }

    /**
     * Transforms TestDescription DTO  object into existing Test entity object.
     *
     * @param testCreatingDto Test creating Dto.
     * @param test existing object.
     * @return Test entity.
     */
    public Test toExistingEntity(TestCreatingDto testCreatingDto, Test test) {
        test.setDescription(testCreatingDto.getTestDescription());
        test.setName(testCreatingDto.getTestName());
        test.setIsPublic(testCreatingDto.getIsPublic());
        return test;
    }

}
