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
     * @param userId User ID.
     * @param userProfileDto Contains user fields.
     * @return Updated user.
     */
    User updateUserProfile(Long userId, UserProfileDto userProfileDto);

    /**
     * Check if selected user has an avatar.
     *
     * @param id User id.
     * @return False is there is no avatar uploaded for current user.
     */
    boolean hasAvatar(Long id);
}
