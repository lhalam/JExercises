package com.softserveinc.ita.jexercises.business.utils;

/**
 * Represents exception object that is thrown if user with current email already
 * exists in database.
 * 
 * @author Oksana Senchuk
 * @version 1.0
 */
public class EmailExistsException extends Exception {
    /**
     * Construct exception object.
     * 
     * @param message
     *            Exception message.
     */
    public EmailExistsException(String message) {
        super(message);
    }
}
