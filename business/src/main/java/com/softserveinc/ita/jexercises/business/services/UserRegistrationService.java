package com.softserveinc.ita.jexercises.business.services;

import com.softserveinc.ita.jexercises.business.utils.EmailExistsException;
import com.softserveinc.ita.jexercises.common.dto.UserDto;

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
     * @return true if registration is successful.
     * @throws EmailExistsException
     *             if user with current email already exists.
     */
    boolean registerNewUserAccount(UserDto userDto) throws EmailExistsException;
}
