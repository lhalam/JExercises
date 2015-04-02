package com.softserveinc.ita.jexercises.business.services;

import com.softserveinc.ita.jexercises.common.dto.UserDto;

/**
 * Service that handles user auto authentication after registration.
 * 
 * @author Oksana Senchuk
 * @version 1.0
 */
public interface AutoLoginService {
    /**
     * Authenticates user immediately after registration.
     * 
     * @param user
     *            Successfully registered user.
     */
    void authenticateUser(UserDto user);
}
