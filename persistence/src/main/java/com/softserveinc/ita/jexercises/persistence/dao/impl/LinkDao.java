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
     *            Link shortCode.
     * @return Link instance if exists or null if there is no link with such
     *         shortCode.
     */
    Link findByShortCode(String shortCode);

    /**
     * Searching link by test id.
     * 
     * @param testId
     *            Id of the test.
     * @return Link instance if exists or null if there is no link with such
     *         shortCode.
     */
    Link findByTestId(Long testId);
}
