package com.softserveinc.ita.jexercises.business.services.impl;

import com.softserveinc.ita.jexercises.business.services.TestService;
import com.softserveinc.ita.jexercises.common.entity.Test;
import com.softserveinc.ita.jexercises.persistence.dao.impl.TestDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Represent TestService interface implementation.
 *
 * @author Ihor demkovych
 * @version 1.0
 */
@Service
public class TestServiceImpl implements TestService {

    /**
     * TestDao instance.
     */
    @Autowired
    private TestDao testDao;

    @Override
    @Transactional
    public void createTest(Test test) {
        testDao.create(test);
    }

    @Override
    @Transactional
    public Test updateTest(Test test) {
        return testDao.update(test);
    }

    @Override
    @Transactional
    public void deleteTest(Test test) {
        testDao.delete(test);
    }

    @Override
    @Transactional
    public void deleteTestById(Long id) {
        testDao.deleteById(id);
    }

    @Override
    public Test findTestById(Long id) {
        return testDao.findById(id);
    }

    @Override
    public List<Test> findAllTests() {
        return testDao.findAll();
    }

    @Override
    public List<Test> findAllTestsByQuestionId(Long questionId) {
        return testDao.findAllByQuestionId(questionId);
    }
}
