package com.softserveinc.ita.jexercises.business.services;

import com.softserveinc.ita.jexercises.common.dto.UserDto;
import com.softserveinc.ita.jexercises.common.dto.UserProfileDto;
import com.softserveinc.ita.jexercises.common.entity.User;

/**
 * Service layer that calling the methods of DAO layer to perform CRUD
 * operations.
 *
 * @author Taras Vuyiv
 * @version 1.0
 */
public interface ProfileService {

    /**
     * Getting profile fields of selected user.
     *
     * @param email Email of user to get info.
     * @return User Profile DTO.
     */
    UserProfileDto getUserInfo(String email);

    /**
     * Update user after profile edit form submitting .
     *
     * @param userDto Contains new user fields.
     * @return Updated user.
     */
    User updateUserProfile(UserDto userDto);
}
