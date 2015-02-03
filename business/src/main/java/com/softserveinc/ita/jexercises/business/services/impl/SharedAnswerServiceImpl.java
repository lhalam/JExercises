package com.softserveinc.ita.jexercises.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softserveinc.ita.jexercises.business.services.SharedAnswerService;
import com.softserveinc.ita.jexercises.common.entity.SharedAnswer;
import com.softserveinc.ita.jexercises.persistence.dao.impl.SharedAnswerDao;

/**
 * Represent SharedAnswerService interface implementation
 * 
 * @author Oleg Pavlish
 * @version 1.0
 */
@Service
public class SharedAnswerServiceImpl implements SharedAnswerService {

    /**
     * SharedAnswerDao instance
     */
    @Autowired
    private SharedAnswerDao sharedAnswerDao;

    @Override
    @Transactional
    public void createSharedAnswer(SharedAnswer sharedAnswer) {
        sharedAnswerDao.create(sharedAnswer);
    }

    @Override
    @Transactional
    public SharedAnswer updateSharedAnswer(SharedAnswer sharedAnswer) {
        return sharedAnswerDao.update(sharedAnswer);
    }

    @Override
    @Transactional
    public void deleteSharedAnswer(SharedAnswer sharedAnswer) {
        sharedAnswerDao.delete(sharedAnswer);
    }

    @Override
    @Transactional
    public void deleteSharedAnswerById(Long id) {
        sharedAnswerDao.deleteById(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public SharedAnswer findSharedAnswerById(Long id) {
        return sharedAnswerDao.findById(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<SharedAnswer> findAllSharedAnswers() {
        return sharedAnswerDao.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<SharedAnswer> findAllSharedAnswersByQuestionId(
            Long questionId) {
        return sharedAnswerDao.findAllByQuestionId(questionId);
    }
}
