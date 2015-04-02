package com.softserveinc.ita.jexercises.persistence.dao.impl.hibernate;

import java.util.List;

import com.mysema.query.jpa.impl.JPADeleteClause;
import org.springframework.stereotype.Repository;
import com.mysema.query.jpa.impl.JPAQuery;
import com.softserveinc.ita.jexercises.common.entity.Assert;
import com.softserveinc.ita.jexercises.common.entity.QAssert;
import com.softserveinc.ita.jexercises.persistence.dao.impl.AssertDao;

/**
 * Represents Hibernate Assert Dao implementation.
 *
 * @author Kucheryavenko Dmytro
 *
 * @version 1.0
 */
@Repository
public class HibernateAssertDaoImpl extends
        HibernateGenericDaoImpl<Assert, Long> implements AssertDao {

    @Override
    public List<Assert> findByQuestionId(Long questionId) {
        QAssert assertVar = QAssert.assert$;
        JPAQuery query = new JPAQuery(getEntityManager());
        return query.from(assertVar)
                .where(assertVar.question.id.eq(questionId)).list(assertVar);
    }

    @Override
    public void deleteAllByQuestionId(Long questionId) {
        QAssert qAssert = QAssert.assert$;
        new JPADeleteClause(getEntityManager(), qAssert).where(
                qAssert.question.id.eq(questionId)).execute();
    }
}