package com.softserveinc.ita.jexercises.persistence.utils;

import java.util.List;
import com.softserveinc.ita.jexercises.common.entity.User;

public interface UserService {

    User findUserById(Long id);

    User findUserByEmail(String email);

    List<User> findAllUsers();

    void createUser(User user);

    User updateUser(User user);

    void deleteUser(User user);

    void deleteUserById(Long id);

}
