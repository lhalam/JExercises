package com.softserveinc.ita.jexercises.persistence.dao.impl.hibernate;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.softserveinc.ita.jexercises.common.entity.UserAnswer;
import com.softserveinc.ita.jexercises.persistence.dao.UserAnswerDao;

@Repository
public class HibernateUserAnswerDaoImpl extends HibernateGenericDaoImpl<UserAnswer, Long>
		implements UserAnswerDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAnswer> findAllByAttemptId(Long attemptId) {
		List<UserAnswer> result = null;
		try {
			String queryString = "select distinct ua from UserAnswer ua where ua.attemp_id=:attemp_id";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("attempt_id", attemptId);
			result = query.getResultList();
		} catch (NoResultException e) {
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAnswer> findAllByQuestionId(Long questionId) {
		List<UserAnswer> result = null;
		try {
			String queryString = "select distinct ua from UserAnswer ua where ua.question_id=:question_id";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("question_id", questionId);
			result = query.getResultList();
		} catch (NoResultException e) {
		}

		return result;
	}

}
