package com.softserveinc.ita.jexercises.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controls Test result page.
 * 
 * @author Volodymyr Lishchynskiy
 * @version 1.0
 */
@Controller
public class TestResultController {

    /**
     * Method provides mapping on "testresult" input
     *
     * @return ModelAndView object,in current case that actually means returning
     *         testresult.jsp
     */   
    @RequestMapping(value = "/testresult", method = RequestMethod.GET)
    public ModelAndView showTestResultPage() {
        return new ModelAndView("testresult");
    }
}
