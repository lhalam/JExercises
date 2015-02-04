package com.softserveinc.ita.jexercises.business.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.softserveinc.ita.jexercises.common.entity.User;
import com.softserveinc.ita.jexercises.persistence.dao.impl.UserDao;

/**
 * Represents implementation of UserDetailsService used by the
 * DaoAuthenticationProvider.
 * 
 * @author Oksana Senchuk
 *
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    /**
     * User not found message.
     */
    private static final String USER_NOT_FOUND_MESSAGE = "User not found";

    /**
     * Instance of user DAO.
     */
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String email) 
        throws UsernameNotFoundException {
        User user = userDao.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(USER_NOT_FOUND_MESSAGE);
        }
        return buildSecuredUser(user);
    }

    /**
     * Builds specific user for authentication.
     * 
     * @param user
     *            User entity object.
     * @return UserDetails object.
     */
    private UserDetails buildSecuredUser(User user) {
        String userEmail = user.getEmail();
        String password = user.getPassword();
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user
                .getRole().toString());
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(1);
        authList.add(authority);
        UserDetails userDetails = 
                new org.springframework.security.core.userdetails.User(
                userEmail, password, enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked, authList);
        return userDetails;
    }
}
