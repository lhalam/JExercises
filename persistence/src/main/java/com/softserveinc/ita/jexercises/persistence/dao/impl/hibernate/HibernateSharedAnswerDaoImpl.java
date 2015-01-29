package com.softserveinc.ita.jexercises.persistence.dao.impl.hibernate;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.softserveinc.ita.jexercises.common.entity.SharedAnswer;
import com.softserveinc.ita.jexercises.persistence.dao.impl.SharedAnswerDao;

/**
 * Represents Hibernate SharedAnswer DAO implementation
 * 
 * @author Oleg Pavlish
 * @version 1.0
 */
@Repository
public class HibernateSharedAnswerDaoImpl extends
        HibernateGenericDaoImpl<SharedAnswer, Long> implements SharedAnswerDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<SharedAnswer> findAllByQuestionId(Long questionId) {
        String queryString = "select distinct sa from SharedAnswer sa"
                + " where sa.question_id=:question_id";
        Query query = getEntityManager().createQuery(queryString).setParameter(
                "question_id", questionId);
        return query.getResultList();
    }
}
