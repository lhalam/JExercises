package com.softserveinc.ita.jexercises.persistence.dao.impl.hibernate;

import java.util.List;

import javax.persistence.NoResultException;
import org.springframework.stereotype.Repository;
import com.mysema.query.jpa.impl.JPAQuery;
import com.softserveinc.ita.jexercises.common.entity.Test;
import com.softserveinc.ita.jexercises.common.entity.QTest;
import com.softserveinc.ita.jexercises.persistence.dao.impl.TestDao;

/**
 * Represents Hibernate Test DAO implementation.
 *
 * @author Ihor Demkovych
 * @version 1.0
 */
@Repository
public class HibernateTestDaoImpl extends HibernateGenericDaoImpl<Test, Long>
		implements TestDao {

	@Override
	public List<Test> findAllByQuestionId(Long questionId) {
		QTest qTest = QTest.test;
		JPAQuery query = new JPAQuery(getEntityManager());
		try {
			return query.from(qTest).where(qTest.questions.any().id.eq(questionId)).list(qTest);
		} catch (NoResultException e) {
            return null;
        }
	}

}