package com.softserveinc.ita.jexercises.web.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Controls process of exception.
 *
 * @author Taras Vuyiv
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Constructor for exception.
     *
     */
    public ResourceNotFoundException() {
        super();
    }


    /**
     * Constructor for exception.
     *
     * @param message exception message.
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
