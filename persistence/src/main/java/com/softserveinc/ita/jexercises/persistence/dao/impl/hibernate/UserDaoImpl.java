package com.softserveinc.ita.jexercises.persistence.dao.impl.hibernate;

import javax.persistence.Query;
import com.softserveinc.ita.jexercises.common.entity.User;
import com.softserveinc.ita.jexercises.persistence.dao.UserDao;

public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {

    @Override
    public User findByEmail(String email) {
	Query q = entityManager.createQuery(
		"select u from User u where u.email=:email", User.class)
		.setParameter("email", email);
	return (User) q.getSingleResult();
    }
}
