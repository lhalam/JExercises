package com.softserveinc.ita.jexercises.common.mapper;

import com.softserveinc.ita.jexercises.common.dto.TestStartDto;
import com.softserveinc.ita.jexercises.common.entity.Attempt;
import com.softserveinc.ita.jexercises.common.entity.Question;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents entity mapping tool.
 *
 * @author Volodymyr Yakymiv
 * @version 1.0
 */
@Component
public class TestStartMapper {

    /**
     * Sets TestStart DTO object.
     *
     * @param attempt Attempt object.
     * @return TestStart DTO.
     */
    public TestStartDto toDto(Attempt attempt) {
        TestStartDto testStartDto = new TestStartDto();
        testStartDto.setAttemptId(attempt.getId());
        List<Question> questions = attempt.getTest().getQuestions();
        Question question = questions.iterator().next();
        testStartDto.setQuestionName(question.getName());
        testStartDto.setQuestionDescription(question.getDescription());
        testStartDto.setQuestionListId(createSetOfQuestionId(questions));
        testStartDto.setQuestionQuantity(questions.size());
        return testStartDto;
    }

    /**
     * Sets List of questions id.
     *
     * @param questions List of Question objects.
     * @return List of questions id.
     */
    private List<Long> createSetOfQuestionId(List<Question> questions) {
        List<Long> questionListId = new ArrayList<>();
        for (Question question : questions) {
            questionListId.add(question.getId());
        }
        return questionListId;
    }
}
