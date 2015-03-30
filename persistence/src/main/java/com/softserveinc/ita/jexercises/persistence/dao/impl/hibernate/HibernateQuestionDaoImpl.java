package com.softserveinc.ita.jexercises.persistence.dao.impl.hibernate;

import com.softserveinc.ita.jexercises.common.entity.Question;
import com.softserveinc.ita.jexercises.persistence.dao.impl.QuestionDao;
import org.springframework.stereotype.Repository;

/**
 * Represents Hibernate Question DAO implementation.
 *
 * @author Volodymyr Yakymiv
 * @version 1.0
 */
@Repository
public class HibernateQuestionDaoImpl extends
        HibernateGenericDaoImpl<Question, Long>
        implements QuestionDao {
}
