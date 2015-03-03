package com.softserveinc.ita.jexercises.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.softserveinc.ita.jexercises.business.services.AutoLoginService;
import com.softserveinc.ita.jexercises.business.services.UserRegistrationService;
import com.softserveinc.ita.jexercises.common.dto.ResponseDto;
import com.softserveinc.ita.jexercises.common.dto.UserDto;
import com.softserveinc.ita.jexercises.common.utils.DateUtils;

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
     * Service that handles authentication after registration.
     */
    @Autowired
    private AutoLoginService autoLoginService;

    /**
     * Gets registration form page.
     * 
     * @return Registration page.
     */
    @RequestMapping(value = "/user/registration", method = RequestMethod.GET)
    public ModelAndView showRegistrationForm() {
        ModelAndView modelAndView = new ModelAndView("user/registration");
        modelAndView.addObject("days", DateUtils.getDays());
        modelAndView.addObject("months", DateUtils.getMonths());
        modelAndView.addObject("years", DateUtils.getYears());
        return modelAndView;
    }

    /**
     * Controls registration process.
     * 
     * @param model
     *            UserDto object.
     * @return ResponseDto object.
     */
    @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto registerUserAccount(@RequestBody UserDto model) {
        ResponseDto response = userRegistrationService
                .registerNewUserAccount(model);
        if (response.isSuccess()) {
            autoLoginService.authenticateUser(model);
        }
        return response;
    }
}
