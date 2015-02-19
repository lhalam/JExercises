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

}
