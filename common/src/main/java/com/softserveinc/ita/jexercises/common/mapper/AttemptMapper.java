package com.softserveinc.ita.jexercises.common.mapper;

import com.softserveinc.ita.jexercises.common.dto.AttemptDto;
import com.softserveinc.ita.jexercises.common.entity.Attempt;
import com.softserveinc.ita.jexercises.common.entity.Test;
import com.softserveinc.ita.jexercises.common.entity.User;
import com.softserveinc.ita.jexercises.common.entity.UserAnswer;
import org.springframework.stereotype.Component;

/**
 * Represents entity mapping tool.
 *
 * @author Volodymyr Yakymiv
 * @version 1.0
 */
@Component
public class AttemptMapper {
    /**
     * Sets Attempt Entity object.
     *
     * @param test Test object.
     * @param user User object.
     * @return Attempt.
     */
    public Attempt toEntity(Test test, User user) {
        Attempt attempt = new Attempt();
        attempt.setTest(test);
        attempt.setUser(user);
        return attempt;
    }

    /**
     * Transforming attempt entity to AttemptDto used for grid.
     *
     * @param attempt Attempt entity object.
     * @return Attempt DTO.
     * @author Taras Vuyiv
     */
    public AttemptDto toAttemptDto(Attempt attempt) {
        AttemptDto attemptDto = new AttemptDto();
        String attemptResult;
        int numberOfQuestions = 0;
        int numberOfCorrectAnswers = 0;

        for (UserAnswer answer : attempt.getUserAnswers()) {
            if (answer.isCorrect()) {
                numberOfCorrectAnswers++;
            }
            numberOfQuestions++;
        }
        attemptResult = numberOfCorrectAnswers + " / " + numberOfQuestions;

        attemptDto.setCreatedDate(attempt.getCreatedDate());
        attemptDto.setId(attempt.getId());
        attemptDto.setResult(attemptResult);
        attemptDto.setTestName(attempt.getTest().getName());
        attemptDto.setFirstName(attempt.getUser().getFirstName());
        attemptDto.setLastName(attempt.getUser().getLastName());
        return attemptDto;
    }
}
