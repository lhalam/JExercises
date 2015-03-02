package com.softserveinc.ita.jexercises.business.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserveinc.ita.jexercises.business.services.TestResultService;
import com.softserveinc.ita.jexercises.common.dto.TestResultDto;
import com.softserveinc.ita.jexercises.common.entity.Attempt;
import com.softserveinc.ita.jexercises.common.entity.UserAnswer;
import com.softserveinc.ita.jexercises.common.mapper.TestResultMapper;
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

    /**
     * Mapper from entities to dto.
     */
    @Autowired
    private TestResultMapper testResultMapper;

    @Transactional
    @Override
    public TestResultDto getTestResultInfo(long attemptId) {
        Attempt attempt = attemptDao.findById(attemptId);
        int numberCorrect = countCorrect(attemptId);
        return testResultMapper.toDto(attempt, numberCorrect);
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