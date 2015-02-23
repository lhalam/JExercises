package com.softserveinc.ita.jexercises.business.services;

import com.softserveinc.ita.jexercises.common.dto.UserProfileDto;
import com.softserveinc.ita.jexercises.common.entity.User;

/**
 * Service layer that calling the methods of DAO layer to perform CRUD
 * operations.
 *
 * @author Taras Vuyiv
 * @version 1.0
 */
public interface UserProfileService {

    /**
     * Getting profile fields of selected user.
     *
     * @param user User to get info about.
     * @return User Profile DTO.
     */
    UserProfileDto getUserInfo(User user);

    /**
     * Update user after profile edit form submitting .
     *
     * @param userProfileDto Contains user fields.
     * @return Updated user.
     */
    User updateUserProfile(UserProfileDto userProfileDto);
}
