package com.softserveinc.ita.jexercises.persistence.dao.impl.hibernate;

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
}
