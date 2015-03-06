package com.softserveinc.ita.jexercises.common.mapper;

import com.softserveinc.ita.jexercises.common.entity.Attempt;
import com.softserveinc.ita.jexercises.common.entity.Question;
import com.softserveinc.ita.jexercises.common.entity.UserAnswer;
import org.springframework.stereotype.Component;

/**
 * Represents entity mapping tool.
 *
 * @author Volodymyr Yakymiv
 * @version 1.0
 */
@Component
public class UserAnswerMapper {

    /**
     * Sets UserAnswer entity object.
     *
     * @param attempt Attempt object.
     * @param question  Question object.
     * @return UserAnswer entity.
     */
    public UserAnswer toEntity(Attempt attempt, Question question) {
        UserAnswer userAnswer = new UserAnswer();
        userAnswer.setAttempt(attempt);
        userAnswer.setQuestion(question);
        return userAnswer;
    }
}
