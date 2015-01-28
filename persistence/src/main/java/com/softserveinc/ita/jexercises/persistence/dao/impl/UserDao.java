package com.softserveinc.ita.jexercises.persistence.dao.impl;

import com.softserveinc.ita.jexercises.common.entity.User;

/**
 * DAO of user.
 * 
 * @author Oksana Senchuk
 * @version 1.0
 */
public interface UserDao extends GenericDao<User, Long> {

    /**
     * Searching user by email.
     * 
     * @param email
     *            User email.
     * @return User instance if exists or null if there is no user with such
     *         email.
     */
    User findByEmail(String email);
}
