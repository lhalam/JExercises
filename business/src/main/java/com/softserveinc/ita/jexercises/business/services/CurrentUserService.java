package com.softserveinc.ita.jexercises.business.services;

import com.softserveinc.ita.jexercises.common.entity.User;

/**
 * Service for getting current user using SpringSecurity.
 *
 * @author Taras Vuyiv
 */
public interface CurrentUserService {
    /**
     * Getting current user from SecurityContextHolder.
     *
     * @return Current user.
     */
    User getCurrentUser();
}
