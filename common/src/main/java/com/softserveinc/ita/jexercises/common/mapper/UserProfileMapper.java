package com.softserveinc.ita.jexercises.common.mapper;

import com.softserveinc.ita.jexercises.common.dto.UserProfileDto;
import com.softserveinc.ita.jexercises.common.entity.User;

/**
 * Represents entity/DTO mapping tool.
 *
 * @author Taras Vuyiv
 */
public class UserProfileMapper {

    /**
     * Transforms UserProfileDto object into User entity object.
     *
     * @param userProfileDto UserProfile DTO.
     * @param user           User entity.
     * @return User entity.
     */
    public User toEntity(User user, UserProfileDto userProfileDto) {

        if (!userProfileDto.getLastName().isEmpty()) {
            user.setLastName(userProfileDto.getLastName());
        }

        if (!userProfileDto.getFirstName().isEmpty()) {
            user.setFirstName(userProfileDto.getFirstName());
        }

        if (!userProfileDto.getPassword().isEmpty()) {
            user.setPassword(userProfileDto.getPassword());
        }

        if (userProfileDto.getAvatar() != null) {
            user.setAvatar(userProfileDto.getAvatar());
        }

        if (userProfileDto.getRole() != null) {
            user.setRole(userProfileDto.getRole());
        }

        return user;
    }

    /**
     * Transforms User entity object into UserProfile DTO object.
     *
     * @param user User entity.
     * @return UserProfile DTO.
     */
    public UserProfileDto toDto(User user) {
        UserProfileDto userProfileDto = new UserProfileDto();
        userProfileDto.setAvatar(user.getAvatar());
        userProfileDto.setEmail(user.getEmail());
        userProfileDto.setFirstName(user.getFirstName());
        userProfileDto.setLastName(user.getLastName());
        userProfileDto.setRegistrationDate(user.getCreatedDate());
        userProfileDto.setRole(user.getRole());
        userProfileDto.setBirthDate(user.getBirthDate());

        return userProfileDto;
    }
}
