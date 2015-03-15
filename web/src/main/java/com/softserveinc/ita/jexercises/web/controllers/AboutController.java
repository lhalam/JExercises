package com.softserveinc.ita.jexercises.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controls about page.
 *
 * @author Volodymyr Yakymiv
 * @version 1.0
 */
@Controller
public class AboutController {

    /**
     * Getting About view.
     *
     * @return ModelAndView About page.
     */
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public ModelAndView printWelcome() {
        return new ModelAndView("about");
    }
}
