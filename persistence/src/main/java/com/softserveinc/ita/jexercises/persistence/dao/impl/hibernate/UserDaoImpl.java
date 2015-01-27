package com.softserveinc.ita.jexercises.persistence.dao.impl.hibernate;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.softserveinc.ita.jexercises.common.entity.User;
import com.softserveinc.ita.jexercises.persistence.dao.UserDao;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {

    @Override
    public User findByEmail(String email) throws NoResultException {
	Query q = entityManager.createQuery(
		"select u from User u where u.email=:email", User.class)
		.setParameter("email", email);
	return (User) q.getSingleResult();
    }
}
