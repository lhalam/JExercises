package com.softserveinc.ita.jexercises.common.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.softserveinc.ita.jexercises.common.dto.TestResultAnswerDto;
import com.softserveinc.ita.jexercises.common.dto.TestResultDto;
import com.softserveinc.ita.jexercises.common.entity.Attempt;
import com.softserveinc.ita.jexercises.common.entity.Test;
import com.softserveinc.ita.jexercises.common.entity.UserAnswer;

/**
 * Represents entity/DTO mapping tool.
 *
 * @author Volodymyr Lishchynskiy
 * @version 1.0
 */
@Component
public class TestResultMapper {
    /**
     * 
     * @param attempt
     *            Concrete attempt.
     * @param countCorrect
     *            Number of correct answers.
     * @return Dto with all parameters for test result.
     */
    public TestResultDto toDto(Attempt attempt, int countCorrect) {
        Test test = attempt.getTest();
        TestResultDto testResultDto = new TestResultDto();
        List<TestResultAnswerDto> testResultAnswerDtos
            = new ArrayList<TestResultAnswerDto>();
        Set<UserAnswer> answers = attempt.getUserAnswers();
        for (UserAnswer userAnswer : answers) {
            TestResultAnswerDto testResultAnswerDto = new TestResultAnswerDto();

            if (userAnswer.isCorrect()) {
                testResultAnswerDto.setIsCorrect("Correct");
            } else {
                testResultAnswerDto.setIsCorrect("Incorrect");
            }

            testResultAnswerDto.setQuestionName(userAnswer.getQuestion()
                    .getName());
            testResultAnswerDtos.add(testResultAnswerDto);
        }

        testResultDto.setAnswers(testResultAnswerDtos);
        testResultDto.setPublic(test.getIsPublic());
        testResultDto.setTotalAnswersCount(answers.size());
        testResultDto.setCorrectAnswersCount(countCorrect);

        return testResultDto;
    }
}
