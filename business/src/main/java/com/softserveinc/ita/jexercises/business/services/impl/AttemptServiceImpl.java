package com.softserveinc.ita.jexercises.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softserveinc.ita.jexercises.business.services.AttemptService;
import com.softserveinc.ita.jexercises.common.entity.Attempt;
import com.softserveinc.ita.jexercises.persistence.dao.impl.AttemptDao;

/**
 * Represents AttemptService interface implementation.
 * 
 * @author Volodymyr Lishchynskiy
 * @version 1.0
 */
@Service
public class AttemptServiceImpl implements AttemptService {

    /**
     * AttemptDao instance.
     */
    @Autowired
    private AttemptDao attemptDao;

    @Override
    @Transactional
    public void createAttempt(Attempt attempt) {
        attemptDao.create(attempt);

    }

    @Override
    @Transactional
    public Attempt updateAttempt(Attempt attempt) {
        return attemptDao.update(attempt);
    }

    @Override
    @Transactional
    public void deleteAttempt(Attempt attempt) {
        attemptDao.delete(attempt);
    }

    @Override
    @Transactional
    public void deleteAttemptById(Long id) {
        attemptDao.deleteById(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Attempt findAttemptById(Long id) {
        return attemptDao.findById(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Attempt> findAllAttempts() {
        return attemptDao.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Attempt> findAllByUserId(Long id) {
        return attemptDao.findAllByUserId(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Attempt> findAllByTestId(Long id) {
        return attemptDao.findAllByTestId(id);
    }

}
