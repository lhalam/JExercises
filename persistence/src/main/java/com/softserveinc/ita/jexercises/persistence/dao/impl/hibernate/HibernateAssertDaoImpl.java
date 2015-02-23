package com.softserveinc.ita.jexercises.persistence.dao.impl.hibernate;

import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.Query;

import com.softserveinc.ita.jexercises.common.entity.Assert;
import com.softserveinc.ita.jexercises.persistence.dao.impl.AssertDao;

/**
 * Represents Hibernate Assert Dao implementation
 * 
 * @author Kucheryavenko Dmytro
 *
 * @version 1.0
 */
@Repository
public class HibernateAssertDaoImpl extends
        HibernateGenericDaoImpl<Assert, Long> implements AssertDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<Assert> findAllByQuestion(Long questionId) {
        String queryString = "select distinct as from Assert as"
                + " where as.question_id=:question_id";
        Query query = getEntityManager().createQuery(queryString).setParameter(
                "question_id", questionId);
        return query.getResultList();
    }

}
