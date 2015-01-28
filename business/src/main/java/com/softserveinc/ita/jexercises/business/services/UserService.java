package com.softserveinc.ita.jexercises.business.services;

import java.util.List;
import com.softserveinc.ita.jexercises.common.entity.User;

/**
 * Service layer that calling the methods of DAO layer to perform CRUD
 * operations.
 * 
 * @author Oksana Senchuk
 * @version 1.0
 */
public interface UserService {

    /**
     * Searching user by id.
     * 
     * @param id
     *            Id of User.
     * @return User instance.
     */
    User findUserById(Long id);

    /**
     * Searching user by email.
     * 
     * @param email
     *            User email.
     * @return User instance.
     */
    User findUserByEmail(String email);

    /**
     * Gets all users.
     * 
     * @return List of users.
     */
    List<User> findAllUsers();

    /**
     * Creates new user.
     * 
     * @param user
     *            New user.
     */
    void createUser(User user);

    /**
     * Updates user.
     * 
     * @param user
     *            Modified user.
     * @return Updated user.
     */
    User updateUser(User user);

    /**
     * Deletes user.
     * 
     * @param user
     *            Unnecessary user.
     */
    void deleteUser(User user);

    /**
     * Deletes user by id.
     * 
     * @param id
     *            Id of unnecessary User.
     */
    void deleteUserById(Long id);

}
