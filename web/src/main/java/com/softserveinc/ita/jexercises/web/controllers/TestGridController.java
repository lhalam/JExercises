package com.softserveinc.ita.jexercises.web.controllers;

import com.softserveinc.ita.jexercises.business.services.TestGridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controls test data table viewing.
 *
 * @author Ihor Demkovych
 * @version 1.0
 */
@Controller
public class TestGridController {

    /**
     * Service that works with Test Grid DTO.
     */
    @Autowired(required = true)
    private TestGridService testGridService;

    /**
     * Build TestGrid DTO to data table.
     *
     * @param model
     *            Model.
     * @return testgrid page.
     */
    @RequestMapping(value = "/testgrid", method = RequestMethod.GET)
    public ModelAndView allTests(Model model) {
        model.addAttribute("tests",testGridService.buildTestGrid());
        return new ModelAndView("testgrid");
    }

}

