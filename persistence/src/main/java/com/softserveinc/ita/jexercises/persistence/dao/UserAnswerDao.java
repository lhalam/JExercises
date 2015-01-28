package com.softserveinc.ita.jexercises.persistence.dao;

import java.util.List;

import com.softserveinc.ita.jexercises.common.entity.UserAnswer;

public interface UserAnswerDao extends GenericDao<UserAnswer, Long> {

	public List<UserAnswer> findAllByAttemptId(Long attemptId);

	public List<UserAnswer> findAllByQuestionId(Long questionId);
}
