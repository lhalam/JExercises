package com.softserveinc.ita.jexercises.common.utils;

import com.softserveinc.ita.jexercises.common.entity.BaseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * Represents EntityListener used for Auditing in BaseEntity.
 *
 * @author Taras Vuyiv
 */
public class AuditEntityListener {

    /**
     * Final anonymous user string.
     */
    private static final String ANONYMOUS_USER = "anonymous";

    /**
     * On record creation.
     *
     * @param e Base Entity object.
     */
    @PrePersist
    public void prePersist(BaseEntity e) {
        e.setCreatedByUser(getCurrentUserEmail());
        e.setCreatedDate(new Date());
    }

    /**
     * On record update.
     *
     * @param e Base Entity object.
     */
    @PreUpdate
    public void preUpdate(BaseEntity e) {
        e.setModifiedByUser(getCurrentUserEmail());
        e.setModifiedDate(new Date());
    }

    /**
     * Getting current user from SpringSecurity.
     *
     * @return Current use email.
     */
    private String getCurrentUserEmail() {
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
