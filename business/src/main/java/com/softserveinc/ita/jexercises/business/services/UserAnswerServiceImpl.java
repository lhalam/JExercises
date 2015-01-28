package com.softserveinc.ita.jexercises.business.services;

import java.util.List;

import com.softserveinc.ita.jexercises.common.entity.UserAnswer;
import com.softserveinc.ita.jexercises.persistence.dao.UserAnswerDao;

@Service
public class UserAnswerServiceImpl implements UserAnswerService {

	private UserAnswerDao userAnswerDao;

	public UserAnswerServiceImpl(UserAnswerDao userAnswerDao) {
		this.userAnswerDao = userAnswerDao;
	}

	@Override
	public void createUserAnswer(UserAnswer userAnswer) {
		userAnswerDao.create(userAnswer);

	}

	@Override
	public UserAnswer updateUserAnswer(UserAnswer userAnswer) {
		return userAnswerDao.update(userAnswer);
	}

	@Override
	public void deleteUserAnswer(UserAnswer userAnswer) {
		userAnswerDao.delete(userAnswer);

	}

	@Override
	public void deleteUserAnswerById(Long id) {
		userAnswerDao.deleteById(id);
	}

	@Override
	public UserAnswer findUserAnswerById(Long id) {
		return userAnswerDao.findById(id);
	}

	@Override
	public List<UserAnswer> findAllUserAnswers() {
		return userAnswerDao.findAll();
	}

	@Override
	public List<UserAnswer> findAllUserAnswersByAttemptId(Long testId) {
		return userAnswerDao.findAllByAttemptId(testId);
	}

	@Override
	public List<UserAnswer> findAllUserAnswersByQuestionId(Long questionId) {
		return userAnswerDao.findAllByQuestionId(questionId);
	}

}
