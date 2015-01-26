package com.softserveinc.ita.jexercises.persistence.utils;

import java.util.List;
import com.softserveinc.ita.jexercises.common.entity.User;
import com.softserveinc.ita.jexercises.persistence.dao.UserDao;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
	this.userDao = userDao;
    }

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
    public void createUser(User user) {
	userDao.create(user);
    }

    @Override
    public User updateUser(User user) {
	return userDao.update(user);
    }

    @Override
    public void deleteUser(User user) {
	userDao.delete(user);
    }

    @Override
    public void deleteUserById(Long id) {
	userDao.deleteById(id);
    }

}
