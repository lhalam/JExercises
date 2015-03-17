package com.softserveinc.ita.jexercises.persistence.dao.impl.hibernate;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.softserveinc.ita.jexercises.common.entity.Assert;

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
    public List<Assert> findAllByQuestionId(Long questionId) {
        try {
            String squerty = "select distinct ua from Assert ua "
                    + "where ua.question.id=:questionId";
            Query q = getEntityManager().createQuery(squerty);
            q.setParameter("questionId", questionId);
            @SuppressWarnings("unchecked")
            List<Assert> asserts = (List<Assert>) q.getResultList();
            return asserts;
        } catch (NoResultException e) {
            return null;
        }
    }
}
