package com.softserveinc.ita.jexercises.web.controllers;

import com.softserveinc.ita.jexercises.business.services.TestDescriptionService;
import com.softserveinc.ita.jexercises.common.dto.TestDescriptionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controls test description page.
 *
 * @author Volodymyr Yakymiv
 * @version 1.0
 */
@Controller
public class TestDescriptionController {
    /**
     * Service that handles get test description process.
     */
    @Autowired
    private TestDescriptionService testDescriptionService;

    /**
     * Gets test description form page.
     *
     * @param model Model.
     * @return Test Description page.
     */
    @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
    public ModelAndView showTestDescriptionForm(Model model) {
        return new ModelAndView("test/testdescription");
    }

    /**
     * Make TestDescription.
     *
     * @param id test id.
     * @return TestDescriptionDto object.
     */
    @RequestMapping(value = "/test/{id}", method = RequestMethod.POST)
    @ResponseBody
    public TestDescriptionDto showTestDescriptionForm(@PathVariable("id") Long id) {
        TestDescriptionDto testDescriptionDto = testDescriptionService.getTestDescription(id);
        return testDescriptionDto;
    }
}
