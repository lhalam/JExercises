package com.softserveinc.ita.jexercises.business.services.impl;

import com.softserveinc.ita.jexercises.business.services.CurrentUserService;
import com.softserveinc.ita.jexercises.business.services.TestDescriptionService;
import com.softserveinc.ita.jexercises.common.dto.TestDescriptionDto;
import com.softserveinc.ita.jexercises.common.entity.Test;
import com.softserveinc.ita.jexercises.common.mapper.TestMapper;
import com.softserveinc.ita.jexercises.persistence.dao.impl.AttemptDao;
import com.softserveinc.ita.jexercises.persistence.dao.impl.TestDao;
import com.softserveinc.ita.jexercises.persistence.dao.impl.UserAnswerDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public TestDescriptionDto getTestDescription(Long testId) {
        TestMapper testMapper = new TestMapper();
        Test test = testDao.findById(testId);
        return testMapper.toDto(test);
    }
    
    @Override
    public boolean isPublicTest( Long testId) {
        Test test = testDao.findById(testId);
        return test.getIsPublic();
    }

}
