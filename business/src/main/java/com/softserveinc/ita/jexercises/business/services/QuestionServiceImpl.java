package com.softserveinc.ita.jexercises.business.services;

import com.softserveinc.ita.jexercises.common.entity.Question;
import com.softserveinc.ita.jexercises.persistence.dao.QuestionDao;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionDao questionDao;

    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public void createQuestion(Question question) {
        questionDao.create(question);

    }

    @Override
    public Question updateQuestion(Question question) {
        return questionDao.update(question);
    }

    @Override
    public void deleteQuestion(Question question) {
        questionDao.delete(question);
    }

    @Override
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
