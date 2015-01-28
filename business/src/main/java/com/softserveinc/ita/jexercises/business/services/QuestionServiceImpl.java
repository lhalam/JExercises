package com.softserveinc.ita.jexercises.business.services;

import com.softserveinc.ita.jexercises.common.entity.Question;
import com.softserveinc.ita.jexercises.persistence.dao.impl.QuestionDao;

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

    /*public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }*/

    @Override
    @Transactional
    public void createQuestion(Question question) {
        questionDao.create(question);

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
