package com.softserveinc.ita.jexercises.business.services.impl;

import com.softserveinc.ita.jexercises.business.services.ProfileService;
import com.softserveinc.ita.jexercises.common.dto.UserDto;
import com.softserveinc.ita.jexercises.common.dto.UserProfileDto;
import com.softserveinc.ita.jexercises.common.entity.User;
import com.softserveinc.ita.jexercises.persistence.dao.impl.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Represents ProfileService interface implementation.
 *
 * @author Taras Vuyiv
 * @version 1.0
 */
@Service
public class ProfileServiceImpl implements ProfileService {
    /**
     * User DAO instance.
     */
    @Autowired
    private UserDao userDao;
    /**
     * Instance of BCryptPasswordEncoder.
     */
    @Autowired
    private BCryptPasswordEncoder encoder;

    /**
     * Getting profile fields of selected user.
     *
     * @param email Email of user to get info.
     * @return User Profile DTO.
     */
    @Transactional
    @Override
    public UserProfileDto getUserInfo(String email) {
        UserProfileDto userProfileDto = new UserProfileDto();

        User user = userDao.findByEmail(email);

        String role = "User";
        if (user.getRole() == User.Role.ROLE_ADMIN) {
            role = "Admin";
        }

        userProfileDto.setAvatar(user.getAvatar());
        userProfileDto.setEmail(user.getEmail());
        userProfileDto.setFirstName(user.getFirstName());
        userProfileDto.setLastName(user.getLastName());
        userProfileDto.setRegistrationDate(user.getCreatedDate());
        userProfileDto.setRole(role);

        return userProfileDto;
    }

    /**
     * Update user after profile edit form submitting .
     *
     * @param userDto Contains new user fields.
     * @return Updated user.
     */
    @Transactional
    @Override
    public User updateUserProfile(UserDto userDto) {
        User user = userDao.findByEmail(userDto.getEmail());
        String firstName = userDto.getFirstName();
        String lastName = userDto.getLastName();
        String password = userDto.getPassword();
        user.setFirstName(firstName);
        user.setLastName(lastName);

        if (!password.isEmpty()) {
            user.setPassword(getHashPassword(password));
        }

        return userDao.update(user);
    }

    /**
     * Encodes password.
     *
     * @param password User password.
     * @return Hashed password.
     */
    private String getHashPassword(String password) {
        return encoder.encode(password);
    }
}
