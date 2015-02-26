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
import com.softserveinc.ita.jexercises.common.mapper.UserMapper;
import com.softserveinc.ita.jexercises.common.utils.Role;
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
     * Registration status.
     */
    private boolean isSuccessfulRegistration;
    /**
     * User DAO instance.
     */
    @Autowired
    private UserDao userDao;
    
    /**
     * UserMapper instance.
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * Instance of BCryptPasswordEncoder.
     */
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional
    @Override
    public boolean registerNewUserAccount(UserDto userDto)
        throws EmailExistsException {
        String email = userDto.getEmail();
        if (emailExist(email)) {
            throw new EmailExistsException(String.format(EMAIL_EXISTS_MESSAGE,
                    email));
        } else {
            User user = userMapper.toEntity(userDto);
            createNewUserAccount(user);
        }
        return isSuccessfulRegistration;
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
     * @param user
     *            User Entity object.
     */
    private void createNewUserAccount(User user) {
        String hashedPassword = hashPassword(user.getPassword());
        user.setPassword(hashedPassword);
        user.setRole(Role.ROLE_USER);
        userDao.create(user);
        isSuccessfulRegistration=true;
    }

    /**
     * Encodes password.
     * 
     * @param password
     *            User password.
     * @return Hashed password.
     */
    private String hashPassword(String password) {
        return encoder.encode(password);
    }

}
