package com.softserveinc.ita.jexercises.persistence.dao.impl.hibernate;

import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.softserveinc.ita.jexercises.common.entity.Assert;
import com.softserveinc.ita.jexercises.persistence.dao.AssertDao;

@Repository
public class HibernateAssertDaoImpl extends
		HibernateGenericDaoImpl<Assert, Long> implements AssertDao {

	@Override
	public List<Assert> findAllByQuestion(Long questionId) {
		try {
			String squerty = "select distinct as from Assert as INNER JOIN as.question q where q.id=:questionId";
			Query q = getEntityManager().createQuery(squerty);
			q.setParameter("questionId", questionId);
			List<Assert> asserts = (List<Assert>) q.getResultList();
			return asserts;
		} catch (NoResultException e) {
			return null;
		}

	}
}
