package com.softserveinc.ita.jexercises.persistence.dao.impl.hibernate;

import org.springframework.stereotype.Repository;
import com.mysema.query.jpa.impl.JPAQuery;
import com.softserveinc.ita.jexercises.common.entity.QUser;
import com.softserveinc.ita.jexercises.common.entity.User;
import com.softserveinc.ita.jexercises.persistence.dao.impl.UserDao;

/**
 * Represents Hibernate User DAO implementation.
 * 
 * @author Oksana Senchuk
 * @version 1.0
 */
@Repository
public class HibernateUserDaoImpl extends HibernateGenericDaoImpl<User, Long>
        implements UserDao {

    @Override
    public User findByEmail(String email) {
        QUser qUser = QUser.user;
        JPAQuery query = new JPAQuery(getEntityManager());
        User user = query.from(qUser).where(qUser.email.eq(email))
                .uniqueResult(qUser);
        return user;
    }
}
