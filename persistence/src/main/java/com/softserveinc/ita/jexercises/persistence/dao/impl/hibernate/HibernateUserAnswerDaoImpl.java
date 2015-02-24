package com.softserveinc.ita.jexercises.persistence.dao.impl.hibernate;

import org.springframework.stereotype.Repository;

import com.softserveinc.ita.jexercises.common.entity.UserAnswer;
import com.softserveinc.ita.jexercises.persistence.dao.impl.UserAnswerDao;

/**
 * Represents Hibernate UserAnswer DAO implementation.
 * 
 * @author Oleg Pavlish
 * @version 1.0
 */
@Repository
public class HibernateUserAnswerDaoImpl extends
        HibernateGenericDaoImpl<UserAnswer, Long> implements UserAnswerDao {
}
