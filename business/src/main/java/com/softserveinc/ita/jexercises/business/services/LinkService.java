package com.softserveinc.ita.jexercises.business.services;

/**
 * Service that handles manipulation with public link.
 * 
 * @author Oksana Senchuk
 * @version 1.0
 */
public interface LinkService {

    /**
     * Creates short code for link.
     * 
     * @param testId
     *            Test id.
     * @return Short code for link.
     */
    String createShortCode(Long testId);

    /**
     * Updates short code for link.
     * 
     * @param testId
     *            Test id.
     * @return Updated short code for link or null if it not exists.
     */
    String updateShortCode(Long testId);

    /**
     * Searches test id by link short code.
     * 
     * @param shortCode
     *            Link short code.
     * @return Test id.
     */
    Long findTestByShortCode(String shortCode);

}
