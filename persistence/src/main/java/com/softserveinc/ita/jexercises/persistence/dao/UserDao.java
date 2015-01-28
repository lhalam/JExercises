package com.softserveinc.ita.jexercises.persistence.dao;

import com.softserveinc.ita.jexercises.common.entity.User;
import com.softserveinc.ita.jexercises.persistence.dao.impl.GenericDao;

public interface UserDao extends GenericDao<User, Long> {

    public User findByEmail(String email);

}
