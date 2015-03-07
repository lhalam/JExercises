package com.softserveinc.ita.jexercises.common.mapper;

import com.softserveinc.ita.jexercises.common.dto.TestCreatingDto;
import com.softserveinc.ita.jexercises.common.entity.Question;
import com.softserveinc.ita.jexercises.common.entity.Test;
import org.springframework.stereotype.Component;
import java.util.List;

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
     * @param questions in the test.
     * @return Test entity.
     */
    public Test toEntity(TestCreatingDto testCreatingDto,
        List<Question> questions) {
        Test test = new Test();
        test.setDescription(testCreatingDto.getTestDescription());
        test.setName(testCreatingDto.getTestName());
        test.setIsPublic(testCreatingDto.getIsPublic());
        test.setQuestions(questions);
        return test;
    }


}
