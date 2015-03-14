package com.softserveinc.ita.jexercises.business.services;

/**
 * Service that handles manipulation with public link.
 * 
 * @author Oksana Senchuk
 * @version 1.0
 */
public interface LinkService {

    /**
     * Updates link if exists or create one.
     * 
     * @param urlPart
     *            Url without short code.
     * @param testId
     *            Test id.
     * @return New or updated link.
     */
    String generateLink(String urlPart, Long testId);

    /**
     * Searches test by public url.
     * 
     * @param url
     *            The public url.
     * @return Test id.
     */
    Long findTestByUrl(String url);

}
