package com.softserveinc.ita.jexercises.business.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.softserveinc.ita.jexercises.business.services.
       UserRegistrationService;
import com.softserveinc.ita.jexercises.business.services.UserService;
import com.softserveinc.ita.jexercises.common.dto.UserDto;
import com.softserveinc.ita.jexercises.common.entity.User;
import com.softserveinc.ita.jexercises.common.entity.User.Role;

/**
 * Represents UserRegistrationService interface implementation.
 * 
 * @author Oksana Senchuk
 * @version 1.0
 */
@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    /**
     * User Service that calling the methods of DAO layer to perform CRUD
     * operations.
     */
    @Autowired
    private UserService userService;

    /**
     * Instance of BCryptPasswordEncoder.
     */
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public User registerNewUserAccount(UserDto userDto) {
        User user = new User();
        String firstName = userDto.getUsername();
        String password = userDto.getPassword();
        String email = userDto.getEmail();
        String lastName = userDto.getUsername();

        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(getHashPassword(password));
        user.setRole(Role.ROLE_USER);
        userService.createUser(user);
        return user;
    }

    /**
     * Encodes password.
     * 
     * @param password
     *            User password.
     * @return Hashed password.
     */
    private String getHashPassword(String password) {
        return encoder.encode(password);
    }
}
