package com.softserveinc.ita.jexercises.persistence.dao.impl.hibernate;

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
public class HibernateTestDaoImpl extends HibernateGenericDaoImpl<Test, Long>
		implements TestDao {
}