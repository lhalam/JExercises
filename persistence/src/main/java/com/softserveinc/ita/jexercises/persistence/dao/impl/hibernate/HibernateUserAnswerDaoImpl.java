package com.softserveinc.ita.jexercises.persistence.dao.impl.hibernate;

import com.mysema.query.jpa.impl.JPAQuery;
import com.softserveinc.ita.jexercises.common.entity.QUserAnswer;
import com.softserveinc.ita.jexercises.common.entity.UserAnswer;
import com.softserveinc.ita.jexercises.persistence.dao.impl.UserAnswerDao;
import org.springframework.stereotype.Repository;

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
        QUserAnswer userAnswer = QUserAnswer.userAnswer;
        JPAQuery query = new JPAQuery(getEntityManager());
        return query.from(userAnswer).distinct().
                where(userAnswer.attempt.id.eq(attemptId),
                        userAnswer.question.id.eq(questionId)).
                singleResult(userAnswer);
    }

    @Override
    public List<UserAnswer> findAllByAttemptId(Long attemptId) {
        QUserAnswer userAnswer = QUserAnswer.userAnswer;
        JPAQuery query = new JPAQuery(getEntityManager());
        return query.from(userAnswer).
                where(userAnswer.attempt.id.eq(attemptId)).list(userAnswer);
    }
}
