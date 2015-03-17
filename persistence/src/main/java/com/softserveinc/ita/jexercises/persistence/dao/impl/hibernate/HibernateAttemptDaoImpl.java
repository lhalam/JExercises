package com.softserveinc.ita.jexercises.persistence.dao.impl.hibernate;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.softserveinc.ita.jexercises.common.entity.Attempt;

import com.softserveinc.ita.jexercises.persistence.dao.impl.AttemptDao;

/**
 * Represents Hibernate Attempt DAO implementation.
 * 
 * @author Volodymyr Lishchynskiy
 * @version 1.0
 */
@Repository
public class HibernateAttemptDaoImpl extends
        HibernateGenericDaoImpl<Attempt, Long> implements AttemptDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<Attempt> findAllByUserId(Long userId) {
        try {
            String squery = "select a from Attempt a where a.user.id=:userId_";
            Query q = getEntityManager().createQuery(squery);
            q.setParameter("userId_", userId);
            List<Attempt> attempts = (List<Attempt>) q.getResultList();
            return attempts;
        } catch (NoResultException e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Attempt> findAllByTestId(Long testId) {
        try {
            String squery = "select a from Attempt a where a.test.id=:testId_";
            Query q = getEntityManager().createQuery(squery);
            q.setParameter("testId_", testId);
            List<Attempt> attempts = (List<Attempt>) q.getResultList();
            return attempts;
        } catch (NoResultException e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Attempt findAttemptByTestIdAndUserId(Long testId, Long userId){
        try {
            TypedQuery<Attempt> query = getEntityManager().createQuery(
                    "select a from Attempt a where a.test.id=:testId " +
                    "and a.user.id=:userId order by a.id desc ",Attempt.class)
                    .setParameter("testId", testId).setParameter("userId",
                            userId).setMaxResults(1);
            return  query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
