package com.softserveinc.ita.jexercises.business.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserveinc.ita.jexercises.business.services.TestResultService;
import com.softserveinc.ita.jexercises.common.dto.TestResultAnswerDto;
import com.softserveinc.ita.jexercises.common.dto.TestResultDto;
import com.softserveinc.ita.jexercises.common.entity.Attempt;
import com.softserveinc.ita.jexercises.common.entity.Test;
import com.softserveinc.ita.jexercises.common.entity.User;
import com.softserveinc.ita.jexercises.common.entity.UserAnswer;
import com.softserveinc.ita.jexercises.persistence.dao.impl.AttemptDao;

/**
 * Represents TestResultService interface implementation.
 * 
 * @author Volodymyr Lishchynskiy
 * @version 1.0
 */
@Service
public class TestResultServiceImpl implements TestResultService {

    /**
     * Attempt DAO instance.
     */
    @Autowired
    private AttemptDao attemptDao;

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public TestResultDto getTestResultInfo(long attemptId) {
        TestResultDto testResultDto = new TestResultDto();
        List<TestResultAnswerDto> testResultAnswerDtos
            = new ArrayList<TestResultAnswerDto>();
        Attempt attempt = attemptDao.findById(attemptId);
        User user = attempt.getUser();
        Test test = attempt.getTest();
        testResultDto.setFirstName(user.getFirstName());
        testResultDto.setLastName(user.getLastName());        
        testResultDto.setCreateDate(attempt.getCreatedDate());
        testResultDto.setTotalAnswersCount(attempt.getUserAnswers().size());
        testResultDto.setCorrectAnswersCount(countCorrect(attemptId));
        testResultDto.setRole(user.getRole());
        testResultDto.setPublic(test.getIsPublic());
        List<UserAnswer> userAnswers = new ArrayList<UserAnswer>(
                attempt.getUserAnswers());
        for (UserAnswer userAnswer : userAnswers) {
            TestResultAnswerDto testResultAnswerDto = new TestResultAnswerDto();
            testResultAnswerDto.setCorrect(userAnswer.isCorrect());

            testResultAnswerDto.setQuestionName(userAnswer.getQuestion()
                    .getName());
            testResultAnswerDtos.add(testResultAnswerDto);
        }

        testResultDto.setAnswers(testResultAnswerDtos);

        return testResultDto;
    }

    @Override
    public int countCorrect(long attemptId) {
        int count = 0;
        Attempt attempt = attemptDao.findById(attemptId);
        List<UserAnswer> answers = new ArrayList<UserAnswer>(
                attempt.getUserAnswers());
        for (UserAnswer ua : answers) {
            if (ua.isCorrect()) {
                count++;
            }
        }
        return count;
    }
}
