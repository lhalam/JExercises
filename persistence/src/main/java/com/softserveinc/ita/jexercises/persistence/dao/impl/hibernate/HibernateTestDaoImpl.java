package com.softserveinc.ita.jexercises.persistence.dao.impl.hibernate;

import com.softserveinc.ita.jexercises.common.entity.Question;
import com.softserveinc.ita.jexercises.common.entity.Test;
import com.softserveinc.ita.jexercises.common.entity.User;
import com.softserveinc.ita.jexercises.persistence.dao.TestDao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import java.util.List;

@Repository
public class HibernateTestDaoImpl extends HibernateGenericDaoImpl<Test, Long> implements TestDao {
    @Override
    public List<Test> findAllByQuestionId(Long questionId) {
        try {
            String squerty = "select distinct t from Test t INNER JOIN t.question t where t.id=:questionId";
            Query t = getEntityManager().createQuery(squerty);
            t.setParameter("questionId", questionId);
            List<Test> tests = (List<Test>) t.getResultList();
            return tests;
        } catch (NoResultException e) {
            return null;
        }
    }
}