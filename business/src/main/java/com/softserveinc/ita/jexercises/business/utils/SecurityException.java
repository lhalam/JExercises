package com.softserveinc.ita.jexercises.business.utils;

/**
 * Represents exception object that is thrown if user try to input
 * runtime denied permission or try to use denied class and package
 *
 * @author Volodymyr Yakymiv.
 * @version 1.0
 */
public class SecurityException extends Exception {

    /**
     * Construct exception object.
     *
     * @param message
     *            Exception message.
     */
    public SecurityException(String message) {
        super(message);
    }
}
