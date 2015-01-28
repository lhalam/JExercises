package com.softserveinc.ita.jexercises.persistence.dao.impl;

import com.softserveinc.ita.jexercises.common.entity.User;

public interface UserDao extends GenericDao<User, Long> {

    User findByEmail(String email);
}
