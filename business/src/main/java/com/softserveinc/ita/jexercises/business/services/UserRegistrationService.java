package com.softserveinc.ita.jexercises.business.services;


import com.softserveinc.ita.jexercises.common.dto.ResponseDto;
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
     * @return Response DTO object .
     */
    ResponseDto registerNewUserAccount(UserDto userDto);
}
