package com.softserveinc.ita.jexercises.common.dto;

import java.util.HashSet;

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
    private boolean success;

    /**
     * Collection of errors.
     */
    private HashSet<String> errors = new HashSet<String>();

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public HashSet<String> getErrors() {
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
    }
}
