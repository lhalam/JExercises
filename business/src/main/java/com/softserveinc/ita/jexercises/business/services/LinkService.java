package com.softserveinc.ita.jexercises.business.services;

/**
 * Service that handles manipulation with public link.
 * 
 * @author Oksana Senchuk
 * @version 1.0
 */
public interface LinkService {

    /**
     * Generates or regenerates public link.
     * 
     * @param testId
     *            Test id.
     * @return New or updated public link.
     */
    String generateLink(Long testId);

    /**
     * Searches test by link.
     * 
     * @param shortCode
     *            The public url shortCode.
     * @return Test id.
     */
    Long findTestByLink(String shortCode);

}
