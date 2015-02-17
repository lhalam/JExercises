package com.softserveinc.ita.jexercises.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controls viewing test datatable
 *
 * @author Ihor Demkovych
 * @version 1.0
 */
@Controller
public class TestGridController {

    /**
     * Method provides mapping on "testgrid" input
     *
     * @return ModelAndView object,in current case that actually means returning
     *         testgrid.jsp
     */
    @RequestMapping(value = "/testgrid", method = RequestMethod.GET)
    public ModelAndView testgrid() {
        return new ModelAndView("testgrid");
    }
}