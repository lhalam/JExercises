package com.softserveinc.ita.jexercises.persistence.dao.impl.hibernate;

import java.util.List;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.softserveinc.ita.jexercises.common.entity.User;
import com.softserveinc.ita.jexercises.persistence.dao.impl.UserDao;

@Repository
public class HibernateUserDaoImpl extends HibernateGenericDaoImpl<User, Long>
	implements UserDao {

    @Override
    public User findByEmail(String email) {
	User user = null;
	TypedQuery<User> q = getEntityManager().createQuery(
		"select u from User u where u.email=:email", User.class)
		.setParameter("email", email);
	List<User> list = q.getResultList();
	if (!list.isEmpty()) {
	    user = (User) list.get(0);
	}
	return user;
    }
}
