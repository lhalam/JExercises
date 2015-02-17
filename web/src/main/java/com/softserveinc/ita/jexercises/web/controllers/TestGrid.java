package com.softserveinc.ita.jexercises.web.controllers;

import com.softserveinc.ita.jexercises.business.services.UserRegistrationService;
import com.softserveinc.ita.jexercises.business.utils.EmailExistsException;
import com.softserveinc.ita.jexercises.common.dto.TestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
public class TestGrid {

    /**
     * Service that handles user registration process.
     */
    @Autowired
    private UserRegistrationService userRegistrationService;

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

    /**
     * Starts user registration process.
     *
     * @param userDto
     *            User DTO object.
     * @return Login page.
     */
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registerUserAccount(
            @ModelAttribute("user") UserDto userDto) {
        try {
            userRegistrationService.registerNewUserAccount(userDto);
        } catch (EmailExistsException e) {
            e.printStackTrace();
        }
        return new ModelAndView("login");
    }
}