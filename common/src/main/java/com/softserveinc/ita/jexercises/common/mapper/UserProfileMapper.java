package com.softserveinc.ita.jexercises.common.mapper;

import com.softserveinc.ita.jexercises.common.dto.UserProfileDto;
import com.softserveinc.ita.jexercises.common.entity.User;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

/**
 * Represents entity/DTO mapping tool.
 *
 * @author Taras Vuyiv
 */
@Component
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

        if (!userProfileDto.getNewPassword().isEmpty()) {
            user.setPassword(userProfileDto.getNewPassword());
        }

        if (userProfileDto.getAvatar() != null) {
            user.setAvatar(Base64.decodeBase64(userProfileDto.getAvatar()));
        }

        if (userProfileDto.getBirthDate() != null) {
            user.setBirthDate(userProfileDto.getBirthDate());
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
        if (user.getAvatar() != null) {
            userProfileDto.setAvatar(Base64.encodeBase64String(user.getAvatar()));
        }
        userProfileDto.setId(user.getId());
        userProfileDto.setEmail(user.getEmail());
        userProfileDto.setFirstName(user.getFirstName());
        userProfileDto.setLastName(user.getLastName());
        userProfileDto.setPassword(user.getPassword());
        userProfileDto.setRegistrationDate(user.getCreatedDate());
        userProfileDto.setRole(user.getRole());
        userProfileDto.setBirthDate(user.getBirthDate());

        return userProfileDto;
    }
}
