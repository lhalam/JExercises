package com.softserveinc.ita.jexercises.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserveinc.ita.jexercises.business.services.UserService;
import com.softserveinc.ita.jexercises.common.entity.User;
import com.softserveinc.ita.jexercises.persistence.dao.impl.UserDao;

/**
 * Represents UserService interface implementation.
 * 
 * @author Oksana Senchuk
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * UserDao instance.
     */
    @Autowired
    private UserDao userDao;

    @Override
    public User findUserById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public User findUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    @Override
    @Transactional
    public void createUser(User user) {
        userDao.create(user);
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        return userDao.update(user);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        userDao.delete(user);
    }

    @Override
    @Transactional
    public void deleteUserById(Long id) {
        userDao.deleteById(id);
    }
}
