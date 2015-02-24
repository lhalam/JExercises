package com.softserveinc.ita.jexercises.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Class which includes controllers responsible for Login process.
 * 
 * @author Kucheryavenko Dmytro
 *
 * @version 1.0
 */
@Controller
public class LoginController {
    /**
     * Method provides mapping on "login" input.
     * 
     * @return ModelAndView object,in current case that actually means returning
     *         login.jsp
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    /**
     * Method provides mapping on "logout" input.
     * 
     * @return ModelAndView object,in current case that actually means returning
     *         logout.jsp
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout() {
        return new ModelAndView("logout");
    }

    /**
     * Method provides mapping on "forgotpassword" input.
     *
     * @return ModelAndView object,in current case that actually means returning
     *         forgotpassword.jsp
     */
    @RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
    public ModelAndView forgotpassword() {
        return new ModelAndView("forgotpassword");
    }



}