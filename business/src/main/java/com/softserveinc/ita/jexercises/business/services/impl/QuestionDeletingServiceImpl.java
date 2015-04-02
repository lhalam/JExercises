package com.softserveinc.ita.jexercises.business.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserveinc.ita.jexercises.business.services.QuestionDeletingService;
import com.softserveinc.ita.jexercises.common.entity.Question;
import com.softserveinc.ita.jexercises.persistence.dao.impl.QuestionDao;

/**
 * QuestionDeletinService implementation.
 * 
 * @author Kucheryavenko Dmytro
 *
 * @version 1.0
 */
@Service
public class QuestionDeletingServiceImpl implements QuestionDeletingService {
    /**
     * QuestionDao object.
     */
    @Autowired
    private QuestionDao questionDao;

    @Transactional
    @Override
    public void deleteCurrentQuestion(Long questionId) {
        Question question = questionDao.findById(questionId);
        question.setTests(null);
        questionDao.deleteById(questionId);

    }

}
