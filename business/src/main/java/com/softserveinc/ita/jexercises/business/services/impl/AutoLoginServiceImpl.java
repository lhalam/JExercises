package com.softserveinc.ita.jexercises.business.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.softserveinc.ita.jexercises.business.services.AutoLoginService;
import com.softserveinc.ita.jexercises.common.dto.UserDto;

/**
 * Represents AutoLoginService interface implementation.
 * 
 * @author Oksana Senchuk
 * @version 1.0
 */
@Service
public class AutoLoginServiceImpl implements AutoLoginService {
    /**
     * AuthenticationManager instance.
     */
    @Autowired
    protected AuthenticationManager authenticationManager;

    @Override
    public void authenticateUser(UserDto user) {
        String userName = user.getEmail();
        String password = user.getPassword();
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                userName, password);
        Authentication authentication = authenticationManager
                .authenticate(authRequest);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);
    }

}
