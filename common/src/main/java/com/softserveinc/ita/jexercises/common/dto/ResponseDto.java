package com.softserveinc.ita.jexercises.common.dto;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents Response DTO object.
 * 
 * @author Oksana Senchuk
 * @version 1.0
 */
public class ResponseDto {
    /**
     * Success flag.
     */
    private boolean success = true;

    /**
     * Collection of errors.
     */
    private Set<String> errors = new HashSet<String>();

    public boolean isSuccess() {
        return success;
    }

    public Set<String> getErrors() {
        return errors;
    }

    /**
     * Adds errors to collection.
     * 
     * @param error
     *            Error string.
     */
    public void addError(String error) {
        errors.add(error);
        success = false;
    }
}
