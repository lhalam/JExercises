package com.softserveinc.ita.jexercises.persistence.dao.impl.hibernate;

import org.springframework.stereotype.Repository;

import com.softserveinc.ita.jexercises.common.entity.UserAnswer;
import com.softserveinc.ita.jexercises.persistence.dao.impl.UserAnswerDao;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

/**
 * Represents Hibernate UserAnswer DAO implementation.
 * 
 * @author Oleg Pavlish
 * @version 1.0
 */
@Repository
public class HibernateUserAnswerDaoImpl extends
        HibernateGenericDaoImpl<UserAnswer, Long> implements UserAnswerDao {

    @Override
    public UserAnswer findUserAnswerByQuestionIdAndAttemptId(Long questionId,
                                                             Long attemptId) {
        try {
            String squerty = "select distinct ua from UserAnswer ua " +
                    "where ua.attempt.id=:attemptId and" +
                    " ua.question.id=:questionId";
            Query q = getEntityManager().createQuery(squerty);
            q.setParameter("attemptId", attemptId);
            q.setParameter("questionId", questionId);
            @SuppressWarnings("unchecked")
            UserAnswer userAnswer = (UserAnswer) q.getSingleResult();
            return userAnswer;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<UserAnswer> findAllByAttemptId(Long attemptId) {
        try {
            String squerty = "select distinct ua from UserAnswer ua " +
                    "where ua.attempt.id=:attemptId";
            Query q = getEntityManager().createQuery(squerty);
            q.setParameter("attemptId", attemptId);
            @SuppressWarnings("unchecked")
            List<UserAnswer> userAnswers =
                    (List<UserAnswer>) q.getResultList();
            return userAnswers;
        } catch (NoResultException e) {
            return null;
        }
    }
}
