package com.softserveinc.ita.jexercises.business.services;

import com.softserveinc.ita.jexercises.business.utils.EmailExistsException;
import com.softserveinc.ita.jexercises.common.dto.UserDto;
import com.softserveinc.ita.jexercises.common.entity.User;

/**
 * Service that handles user registration process.
 * 
 * @author Oksana Senchuk
 * @version 1.0
 */
public interface UserRegistrationService {

    /**
     * Registers new user account.
     * 
     * @param userDto
     *            User DTO object.
     * @return Registered user.
     * @throws EmailExistsException
     *             if user with current email already exists.
     */
    User registerNewUserAccount(UserDto userDto) throws EmailExistsException;
}