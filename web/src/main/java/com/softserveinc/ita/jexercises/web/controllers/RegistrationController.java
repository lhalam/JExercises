package com.softserveinc.ita.jexercises.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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
     * Binds user DTO to registration form.
     * 
     * @param model
     *            Model from UI.
     * @return Registration page.
     */
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView showRegistrationForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return new ModelAndView("registration");
    }
}
