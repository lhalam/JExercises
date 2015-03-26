package com.softserveinc.ita.jexercises.web.controllers;

import com.softserveinc.ita.jexercises.web.utils.ResourceNotFoundException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Controls exception handling.
 *
 * @author Volodymyr Yakymiv
 * @version 1.0
 */
@ControllerAdvice
public class ExceptionHandlingController {

    private static final String NOT_FOUND_INF_MESSAGE =
            "Requested page not found!";
    private static final String FORBIDDEN_INF_MESSAGE =
            "Request to the current resource is denied!";
    private static final String BAD_REQUEST_INF_MESSAGE =
            "Invalid URL!";

    /**
     * Getting error view when HTTP request status code is 404.
     *
     * @return error page.
     */
    @ExceptionHandler({ResourceNotFoundException.class,
            NoHandlerFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView handleResourceNotFoundException() {
        ModelAndView model = new ModelAndView("error");
        model.addObject("message", "404 Not Found");
        model.addObject("info", NOT_FOUND_INF_MESSAGE);
        return model;
    }

    /**
     * Getting error view when HTTP request status code is 403.
     *
     * @return error page.
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ModelAndView handleAccessDeniedException() {
        ModelAndView model = new ModelAndView("error");
        model.addObject("message", "403 Access Denied");
        model.addObject("info", FORBIDDEN_INF_MESSAGE);
        return model;
    }

    /**
     * Getting error view when HTTP request status code is 400.
     *
     * @return error page.
     */
    @ExceptionHandler({TypeMismatchException.class,
            IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ModelAndView handleNullPointerExceptionException() {
        ModelAndView model = new ModelAndView("error");
        model.addObject("message", "400 Bad Request");
        model.addObject("info", BAD_REQUEST_INF_MESSAGE);
        return model;
    }
}
