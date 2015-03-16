package com.softserveinc.ita.jexercises.web.controllers;

import com.softserveinc.ita.jexercises.business.services.CurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private CurrentUserService currentUserService;

    /**
     * Getting welcome view.
     *
     * @return ModelAndView Welcome page.
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView welcomeForm() {
        if (currentUserService.getCurrentUser() == null) {
            return new ModelAndView("welcome");
        } else {
            return new ModelAndView("home");
        }
    }
}
