package com.softserveinc.ita.jexercises.persistence.dao.impl;

import com.softserveinc.ita.jexercises.common.entity.Link;
import com.softserveinc.ita.jexercises.persistence.dao.GenericDao;

/**
 * DAO of link.
 * 
 * @author Oksana Senchuk
 * @version 1.0
 */
public interface LinkDao extends GenericDao<Link, Long> {
    /**
     * Searching link by shortCode.
     * 
     * @param shortCode
     *            Url shortCode.
     * @return Link instance if exists or null if there is no such link.
     */
    Link findByShortCode(String shortCode);
}
