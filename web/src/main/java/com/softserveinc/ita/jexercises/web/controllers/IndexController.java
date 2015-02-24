package com.softserveinc.ita.jexercises.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Class which includes index-controller.
 * 
 * @author Kucheryavenko Dmytro
 *
 * @version 1.0
 */
@Controller
public class IndexController {
    /**
     * Method provides mapping on "index" input.
     * 
     * @return index.jsp
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String printWelcome() {
        return "index";
    }
}
