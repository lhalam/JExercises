package com.softserveinc.ita.jexercises.business.services;

import java.util.List;

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
    public SharedAnswer findSharedAnswerById(Long id) {
        return sharedAnswerDao.findById(id);
    }

    @Override
    public List<SharedAnswer> findAllSharedAnswers() {
        return sharedAnswerDao.findAll();
    }

    @Override
    public List<SharedAnswer> findAllSharedAnswersByQuestionId(
            Long questionId) {
        return sharedAnswerDao.findAllByQuestionId(questionId);
    }
}
