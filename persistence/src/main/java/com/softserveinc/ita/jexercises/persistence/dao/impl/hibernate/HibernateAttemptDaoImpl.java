package com.softserveinc.ita.jexercises.persistence.dao.impl.hibernate;

import com.mysema.query.jpa.impl.JPAQuery;
import com.softserveinc.ita.jexercises.common.entity.Attempt;
import com.softserveinc.ita.jexercises.common.entity.QAttempt;
import com.softserveinc.ita.jexercises.persistence.dao.impl.AttemptDao;
import org.springframework.stereotype.Repository;

/**
 * Represents Hibernate Attempt DAO implementation.
 *
 * @author Volodymyr Lishchynskiy
 * @version 1.0
 */
@Repository
public class HibernateAttemptDaoImpl extends
        HibernateGenericDaoImpl<Attempt, Long> implements AttemptDao {

    @Override
    public Attempt findAttemptByTestIdAndUserId(Long testId, Long userId) {
        QAttempt attempt = QAttempt.attempt;
        JPAQuery query = new JPAQuery(getEntityManager());
        return query.from(attempt).where(attempt.test.id.eq(testId),
                attempt.user.id.eq(userId)).orderBy(attempt.id.desc())
                .singleResult(attempt);
    }
}
