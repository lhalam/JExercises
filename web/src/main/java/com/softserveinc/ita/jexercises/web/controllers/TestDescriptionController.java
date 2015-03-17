package com.softserveinc.ita.jexercises.web.controllers;

import com.softserveinc.ita.jexercises.business.services.TestDescriptionService;
import com.softserveinc.ita.jexercises.business.services.TestService;
import com.softserveinc.ita.jexercises.common.dto.TestDescriptionDto;
import com.softserveinc.ita.jexercises.web.utils.ResourceNotFoundException;
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
     * Service which gives test object.
     */
    @Autowired
    private TestService testService;

    /**
     * Gets test description form page.
     *
     * @param model  Model.
     * @param testId Test id.
     * @return Test Description page.
     * @throws ResourceNotFoundException No test with such id
     * or user does not have access to private test
     */
    @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
    public ModelAndView showTestDescriptionForm(Model model,
                                                @PathVariable("id")
                                                Long testId)
            throws ResourceNotFoundException {
        if (!testDescriptionService.checkDoesUserHavePrivateLink(testId)
                || testService.findTestById(testId) == null) {
            throw new ResourceNotFoundException();
        } else {
            return new ModelAndView("test/testdescription");
        }
    }

    /**
     * Make TestDescription.
     *
     * @param id test id.
     * @return TestDescriptionDto object.
     */
    @RequestMapping(value = "/test/{id}", method = RequestMethod.POST)
    @ResponseBody
    public TestDescriptionDto showTestDescriptionForm(@PathVariable("id")
                                                      Long id) {
        return testDescriptionService.getTestDescription(id);
    }
}
