package com.softserveinc.ita.jexercises.persistence.dao.impl.hibernate;

import com.softserveinc.ita.jexercises.common.entity.Question;
import com.softserveinc.ita.jexercises.persistence.dao.QuestionDao;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

@Repository
public class HibernateQuestionDaoImpl extends HibernateGenericDaoImpl<Question, Long> implements QuestionDao {
    @Override
    public List<Question> findAllByTestId(Long testId) {
        try {
            String squerty = "select distinct q from Question q INNER JOIN q.tests t where t.id=:testId";
            Query q = getEntityManager().createQuery(squerty);
            q.setParameter("testId", testId);
            List<Question> questions = (List<Question>) q.getResultList();
            return questions;
        } catch (NoResultException e) {
            return null;
        }
    }
}