package com.softserveinc.ita.jexercises.business.services;

import com.softserveinc.ita.jexercises.common.dto.LinkDto;

/**
 * Service that handles manipulation with public link.
 * 
 * @author Oksana Senchuk
 * @version 1.0
 */
public interface LinkService {

    /**
     * Saves public link.
     * 
     * @param linkDto
     *            LinkDto instance.
     */
    void saveLink(LinkDto linkDto);

    /**
     * Deletes public link.
     * 
     * @param testId
     *            Test id.
     */
    void deleteLink(Long testId);

    /**
     * Searches test by link.
     * 
     * @param shortCode
     *            The public url shortCode.
     * @return Test id.
     */
    Long findTestByLink(String shortCode);

    /**
     * Generates unique short code for public link.
     * 
     * @return The public url shortCode.
     */
    String generateUniqueShortCode();

}
