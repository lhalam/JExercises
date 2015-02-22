package com.softserveinc.ita.jexercises.common.mapper;

import com.softserveinc.ita.jexercises.common.dto.UserDto;
import com.softserveinc.ita.jexercises.common.entity.User;

/**
 * Represents entity/DTO mapping tool.
 * 
 * @author Oksana Senchuk
 * @version 1.0
 */
public class UserMapper {

    /**
     * Transforms UserDto object into User entity object.
     * 
     * @param userDto
     *            User DTO.
     * @return User entity.
     */
    public User toEntity(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setBirthDate(userDto.getBirthDate());
        user.setPassword(userDto.getPassword());
        return user;
    }

    /**
     * Transforms User entity object into User DTO object.
     * 
     * @param user
     *            User entity.
     * @return User DTO.
     */
    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setBirthDate(user.getBirthDate());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
