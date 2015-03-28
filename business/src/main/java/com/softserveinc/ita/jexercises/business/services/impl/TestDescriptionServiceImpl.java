package com.softserveinc.ita.jexercises.business.services.impl;

import com.softserveinc.ita.jexercises.business.services.CurrentUserService;
import com.softserveinc.ita.jexercises.business.services.TestDescriptionService;
import com.softserveinc.ita.jexercises.common.dto.TestDescriptionDto;
import com.softserveinc.ita.jexercises.common.entity.Attempt;
import com.softserveinc.ita.jexercises.common.entity.Question;
import com.softserveinc.ita.jexercises.common.entity.Test;
import com.softserveinc.ita.jexercises.common.entity.User;
import com.softserveinc.ita.jexercises.common.entity.UserAnswer;
import com.softserveinc.ita.jexercises.common.mapper.AttemptMapper;
import com.softserveinc.ita.jexercises.common.mapper.TestMapper;
import com.softserveinc.ita.jexercises.common.mapper.UserAnswerMapper;
import com.softserveinc.ita.jexercises.persistence.dao.impl.AttemptDao;
import com.softserveinc.ita.jexercises.persistence.dao.impl.TestDao;
import com.softserveinc.ita.jexercises.persistence.dao.impl.UserAnswerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Represents TestDescriptionService interface implementation.
 *
 * @author Volodymyr Yakymiv
 * @version 1.0
 */
@Service
public class TestDescriptionServiceImpl implements TestDescriptionService {

    @Autowired
    private TestDao testDao;

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private AttemptDao attemptDao;

    @Autowired
    private UserAnswerDao userAnswerDao;

    @Autowired
    private AttemptMapper attemptMapper;

    @Autowired
    private UserAnswerMapper userAnswerMapper;

    @Override
    public TestDescriptionDto getTestDescription(Long testId) {
        TestMapper testMapper = new TestMapper();
        Test test = testDao.findById(testId);
        return testMapper.toDto(test);
    }

    @Override
    @Transactional
    public void createAttempt(Long testId) {
        Test test = testDao.findById(testId);
        User user = currentUserService.getCurrentUser();
        Attempt attempt = attemptMapper.toEntity(test, user);
        attemptDao.create(attempt);
        createUserAnswers(attempt);
    }

    @Override
    public boolean isPublicTest(Long testId) {
        Test test = testDao.findById(testId);
        return test.getIsPublic();
    }

    /**
     * Creates User Answer object.
     *
     * @param attempt Attempt object
     */
    private void createUserAnswers(Attempt attempt) {
        List<Question> questions = attempt.getTest().getQuestions();
        for (Question question : questions) {
            UserAnswer userAnswer = userAnswerMapper.toEntity(attempt,
                    question);
            userAnswerDao.create(userAnswer);
        }
    }
}
