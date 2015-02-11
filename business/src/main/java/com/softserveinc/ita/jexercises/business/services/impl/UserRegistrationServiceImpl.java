package com.softserveinc.ita.jexercises.business.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.softserveinc.ita.jexercises.business.services.
       UserRegistrationService;
import com.softserveinc.ita.jexercises.business.utils.EmailExistsException;
import com.softserveinc.ita.jexercises.common.dto.UserDto;
import com.softserveinc.ita.jexercises.common.entity.User;
import com.softserveinc.ita.jexercises.common.entity.User.Role;
import com.softserveinc.ita.jexercises.persistence.dao.impl.UserDao;

/**
 * Represents UserRegistrationService interface implementation.
 * 
 * @author Oksana Senchuk
 * @version 1.0
 */
@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {
    /**
     * User with current email already exists message.
     */
    private static final String EMAIL_EXISTS_MESSAGE 
        = "User with email %s already exists";
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

    @Transactional
    @Override
    public User registerNewUserAccount(UserDto userDto)
        throws EmailExistsException {
        User user = null;
        String email = userDto.getEmail();
        if (emailExist(email)) {
            throw new EmailExistsException(String.format(EMAIL_EXISTS_MESSAGE,
                    email));
        } else {
            user = createNewUserAccount(userDto);
        }
        return user;
    }

    /**
     * Checks if user with current email already exists.
     * 
     * @param email
     *            User email.
     * @return True if user with current email already exists.
     */
    private boolean emailExist(String email) {
        User user = userDao.findByEmail(email);
        return user != null;
    }

    /**
     * Creates new user account.
     * 
     * @param userDto
     *            User DTO object.
     * @return User with registered account.
     */
    private User createNewUserAccount(UserDto userDto) {
        User user = new User();
        String firstName = userDto.getFirstName();
        String lastName = userDto.getLastName();
        String email = userDto.getEmail();
        String password = userDto.getPassword();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(getHashPassword(password));
        user.setRole(Role.ROLE_USER);
        userDao.create(user);
        return user;
    }

    /**
     * Encodes password.
     * 
     * @param password
     *            User password.
     * @return Hashed password.
     */
    private String getHashPassword(String password) {
        return encoder.encode(password);
    }

}
