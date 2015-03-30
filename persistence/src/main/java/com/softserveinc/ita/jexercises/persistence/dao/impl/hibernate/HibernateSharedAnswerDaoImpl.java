package com.softserveinc.ita.jexercises.persistence.dao.impl.hibernate;

import org.springframework.stereotype.Repository;
import com.softserveinc.ita.jexercises.common.entity.SharedAnswer;
import com.softserveinc.ita.jexercises.persistence.dao.impl.SharedAnswerDao;

/**
 * Represents Hibernate SharedAnswer DAO implementation.
 * 
 * @author Oleg Pavlish
 * @version 1.0
 */
@Repository
public class HibernateSharedAnswerDaoImpl extends
        HibernateGenericDaoImpl<SharedAnswer, Long> implements SharedAnswerDao {
}
