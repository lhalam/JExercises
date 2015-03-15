package com.softserveinc.ita.jexercises.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controls welcome page.
 *
 * @author Volodymyr Yakymiv
 * @version 1.0
 */
@Controller
public class WelcomeController {

    /**
     * Getting welcome view.
     *
     * @return ModelAndView Welcome page.
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView welcomeForm() {
        return new ModelAndView("welcome");
    }
}
