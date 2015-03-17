package com.softserveinc.ita.jexercises.business.services.impl;

import com.softserveinc.ita.jexercises.business.services.QuestionService;
import com.softserveinc.ita.jexercises.common.entity.Question;
import com.softserveinc.ita.jexercises.persistence.dao.impl.QuestionDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Represent QuestionService interface implementation.
 *
 * @author Volodymyr Yakymiv
 * @version 1.0
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    /**
     * QuestionDao instance.
     */
    @Autowired
    private QuestionDao questionDao;

    @Override
    @Transactional
    public Long createQuestion(Question question) {
       return questionDao.create(question).getId();

    }

    @Override
    @Transactional
    public Question updateQuestion(Question question) {
        return questionDao.update(question);
    }

    @Override
    @Transactional
    public void deleteQuestion(Question question) {
        questionDao.delete(question);
    }

    @Override
    @Transactional
    public void deleteQuestionById(Long id) {
        questionDao.deleteById(id);
    }

    @Override
    public Question findQuestionById(Long id) {
        return questionDao.findById(id);
    }

    @Override
    public List<Question> findAllQuestions() {
        return questionDao.findAll();
    }

    @Override
    public List<Question> findAllQuestionsByTestId(Long testId) {
        return questionDao.findAllByTestId(testId);
    }
}
