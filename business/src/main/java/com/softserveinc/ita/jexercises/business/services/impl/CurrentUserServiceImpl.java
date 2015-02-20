package com.softserveinc.ita.jexercises.business.services.impl;

import com.softserveinc.ita.jexercises.business.services.CurrentUserService;
import com.softserveinc.ita.jexercises.common.entity.User;
import com.softserveinc.ita.jexercises.persistence.dao.impl.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Service for getting current user using SpringSecurity.
 *
 * @author Taras Vuyiv
 */
@Service
public class CurrentUserServiceImpl implements CurrentUserService {

    /**
     * User DAO instance.
     */
    @Autowired
    private UserDao userDao;

    @Override
    public User getCurrentUser() {

        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }

        return userDao.findByEmail(authentication.getName());
    }
}
