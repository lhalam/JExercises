package com.softserveinc.ita.jexercises.business.services.impl;

import com.softserveinc.ita.jexercises.business.services.UserAnswerService;
import com.softserveinc.ita.jexercises.common.entity.UserAnswer;
import com.softserveinc.ita.jexercises.persistence.dao.impl.UserAnswerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Represent UserAnswerService interface implementation.
 *
 * @author Oleg Pavlish
 * @version 1.0
 */
@Service
public class UserAnswerServiceImpl implements UserAnswerService {

    /**
     * UserAnswerDao instance.
     */
    @Autowired
    private UserAnswerDao userAnswerDao;

    @Override
    @Transactional
    public void createUserAnswer(UserAnswer userAnswer) {
        userAnswerDao.create(userAnswer);
    }

    @Override
    @Transactional
    public UserAnswer updateUserAnswer(UserAnswer userAnswer) {
        return userAnswerDao.update(userAnswer);
    }

    @Override
    @Transactional
    public void deleteUserAnswer(UserAnswer userAnswer) {
        userAnswerDao.delete(userAnswer);

    }

    @Override
    @Transactional
    public void deleteUserAnswerById(Long id) {
        userAnswerDao.deleteById(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public UserAnswer findUserAnswerById(Long id) {
        return userAnswerDao.findById(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<UserAnswer> findAllUserAnswers() {
        return userAnswerDao.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public UserAnswer findUserAnswerByAttemptIdAndQuestionId(Long questionId,
                                                             Long attemptId) {
        return userAnswerDao.findUserAnswerByQuestionIdAndAttemptId(
                questionId, attemptId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<UserAnswer> findAllByAttemptId(Long attemptId) {
        return userAnswerDao.findAllByAttemptId(attemptId);
    }
}
