package com.softserveinc.ita.jexercises.persistence.dao.impl.hibernate;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.softserveinc.ita.jexercises.common.entity.Test;
import com.softserveinc.ita.jexercises.persistence.dao.impl.TestDao;

/**
 * Represents Hibernate Test DAO implementation.
 *
 * @author Ihor Demkovych
 * @version 1.0
 */
@Repository
public class HibernateTestDaoImpl extends
    HibernateGenericDaoImpl<Test, Long> 
    implements TestDao {
    
    @Override
    public List<Test> findAllByQuestionId(Long questionId) {
        try {
            String squerty = "select distinct test from Test test " +
                    "INNER JOIN test.questions t where t.id=:questionId";
            Query q = getEntityManager().createQuery(squerty);
            q.setParameter("questionId", questionId);
            @SuppressWarnings("unchecked")
            List<Test> tests = (List<Test>) q.getResultList();
            return tests;
        } catch (NoResultException e) {
            return null;
        }
    }
}
