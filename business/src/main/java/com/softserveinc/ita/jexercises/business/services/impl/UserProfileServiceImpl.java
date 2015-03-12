package com.softserveinc.ita.jexercises.business.services.impl;

import com.softserveinc.ita.jexercises.business.services.CurrentUserService;
import com.softserveinc.ita.jexercises.business.services.UserProfileService;
import com.softserveinc.ita.jexercises.business.services.UserService;
import com.softserveinc.ita.jexercises.common.dto.UserProfileDto;
import com.softserveinc.ita.jexercises.common.entity.User;
import com.softserveinc.ita.jexercises.common.mapper.UserProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Represents UserProfileService interface implementation.
 *
 * @author Taras Vuyiv
 */
@Service
public class UserProfileServiceImpl implements UserProfileService {
    /**
     * Current User Service instance.
     */
    @Autowired
    private CurrentUserService currentUserService;
    /**
     * User Service instance.
     */
    @Autowired
    private UserService userService;
    /**
     * User Profile Mapper instance.
     */
    @Autowired
    private UserProfileMapper userProfileMapper;
    /**
     * Instance of BCryptPasswordEncoder.
     */
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public UserProfileDto getUserInfo(User user) {
        UserProfileMapper userProfileMapper = new UserProfileMapper();

        return userProfileMapper.toDto(user);
    }

    @Transactional
    @Override
    public User updateUserProfile(Long userId, UserProfileDto userDto) {

        User user = userService.findUserById(userId);

        if (!userDto.getNewPassword().isEmpty()) {
            userDto.setNewPassword(getHashPassword(userDto.getNewPassword()));
        }

        userProfileMapper.toEntity(user, userDto);

        return userService.updateUser(user);
    }

    @Override
    public boolean hasAvatar(Long id) {
        User user = userService.findUserById(id);
        return (user.getAvatar() != null);
    }

    private String getHashPassword(String password) {
        return encoder.encode(password);
    }
}
