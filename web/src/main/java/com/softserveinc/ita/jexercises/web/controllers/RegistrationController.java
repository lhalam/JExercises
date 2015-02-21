package com.softserveinc.ita.jexercises.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.softserveinc.ita.jexercises.business.services.
       UserRegistrationService;
import com.softserveinc.ita.jexercises.business.utils.EmailExistsException;
import com.softserveinc.ita.jexercises.common.dto.UserDto;

/**
 * Controls new user registration process.
 * 
 * @author Oksana Senchuk
 * @version 1.0
 */
@Controller
public class RegistrationController {

    /**
     * Service that handles user registration process.
     */
    @Autowired
    private UserRegistrationService userRegistrationService;

    /**
     * Gets registration form page.
     * 
     * @return Registration page.
     */
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView showRegistrationForm() {
        return new ModelAndView("user/registration");
    }

    /**
     * Starts registration process.
     * 
     * @param model
     *            UserDto object.
     * @return UserDto object.
     */
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @ResponseBody
    public UserDto registerUserAccount(UserDto model) {
        try {
            userRegistrationService.registerNewUserAccount(model);
        } catch (EmailExistsException e) {
            e.printStackTrace();
        }
        return model;
    }
}
