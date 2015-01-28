package com.softserveinc.ita.jexercises.persistence.utils;

import java.util.List;

import com.softserveinc.ita.jexercises.common.entity.UserAnswer;

public interface UserAnswerService {

	void createUserAnswer(UserAnswer userAnswer);

	UserAnswer updateUserAnswer(UserAnswer userAnswer);

	void deleteUserAnswer(UserAnswer userAnswer);

	void deleteUserAnswerById(Long id);

	UserAnswer findUserAnswerById(Long id);

	List<UserAnswer> findAllUserAnswers();

	List<UserAnswer> findAllUserAnswersByAttemptId(Long testId);

	List<UserAnswer> findAllUserAnswersByQuestionId(Long questionId);
}
