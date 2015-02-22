package com.softserveinc.ita.jexercises.business.services.impl;

import com.softserveinc.ita.jexercises.business.services.CurrentUserService;
import com.softserveinc.ita.jexercises.common.entity.User;
import com.softserveinc.ita.jexercises.persistence.dao.impl.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
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
     * Final anonymous user string.
     */
    private static final String ANONYMOUS_USER = "anonymous";
    /**
     * User DAO instance.
     */
    @Autowired
    private UserDao userDao;

    @Override
    public User getCurrentUser() {
        String userEmail = getCurrentUserEmail();

        if (ANONYMOUS_USER.equals(userEmail)) {
            return null;
        }

        return userDao.findByEmail(userEmail);
    }

    @Override
    public String getCurrentUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return ANONYMOUS_USER;
        }

        for (GrantedAuthority auth : authentication.getAuthorities()) {
            if ("ROLE_ANONYMOUS".equals(auth.getAuthority())) {
                return ANONYMOUS_USER;
            }
        }

        return authentication.getName();
    }
}
