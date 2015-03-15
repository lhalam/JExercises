package com.softserveinc.ita.jexercises.business.services;

/**
 * Service that handles manipulation with public link.
 * 
 * @author Oksana Senchuk
 * @version 1.0
 */
public interface LinkService {

    /**
     * Creates new link.
     * 
     * @param urlPart
     *            Url without short code.
     * @param testId
     *            Test id.
     * @return New public link.
     */
    String createLink(String urlPart, Long testId);

    /**
     * Updates link.
     * 
     * @param urlPart
     *            Url without short code.
     * @param testId
     *            Test id.
     * @return Updated link.
     */
    String updateLink(String urlPart, Long testId);

    /**
     * Searches test by public url.
     * 
     * @param url
     *            The public url.
     * @return Test id.
     */
    Long findTestByUrl(String url);

}
