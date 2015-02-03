package com.softserveinc.ita.jexercises.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.softerveinc.ita.jexercises.web.models.LoginModel;

//import com.sendev.model.LoginModel;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(String error) {
        return new ModelAndView("login", "command", new LoginModel());

    }
}