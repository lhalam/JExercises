package com.softserveinc.ita.jexercises.web.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Controls process of exception.
 *
 * @author Oksana Senchuk
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Access denied")
public class AccessDeniedException extends RuntimeException {
	/**
	 * Constructor for exception.
	 *
	 */
	public AccessDeniedException() {
		super();
	}

	/**
	 * Constructor for exception.
	 *
	 * @param message
	 *            exception message.
	 */
	public AccessDeniedException(String message) {
		super(message);
	}
}
