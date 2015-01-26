package com.softserveinc.ita.jexercises.persistence.dao;

import com.softserveinc.ita.jexercises.common.entity.User;

public interface UserDao extends GenericDao<User, Long> {
    public User findByEmail(String email);
}
