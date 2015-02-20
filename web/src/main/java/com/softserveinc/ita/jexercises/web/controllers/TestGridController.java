package com.softserveinc.ita.jexercises.web.controllers;

import com.softserveinc.ita.jexercises.business.services.TestGridService;
import com.softserveinc.ita.jexercises.common.dto.TestGridDto;
import com.softserveinc.ita.jexercises.common.dto.TestGridParametersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * Controls Test result page.
 *
 * @author Ihor Demkovych
 * @version 1.0
 */
@Controller
public class TestGridController {
    /**
     * Service which work with DTO.
     */
    @Autowired
    private TestGridService testGridService;

    /**
     * Method provides mapping on "testgrid" input
     *
     * @param model Model.
     * @return ModelAndView object,in current case that actually means returning
     *         testgrid.jsp
     */
    @RequestMapping(value = "/testgrid", method = RequestMethod.GET)
    public ModelAndView showTestGridPage(Model model) {

        return new ModelAndView("test/testgrid");
    }

    /**
     * Method provides mapping on "testgrid" input
     *
     * @param testGridParametersDto from TestGridParametersDto class.
     * @return TestGridDto object,in current case that actually means returning
     *         json with data to build data table.
     */
    @RequestMapping(value = "/testgrid", method = RequestMethod.POST)
    @ResponseBody
    public TestGridDto showTestGridPage(@RequestBody TestGridParametersDto
                                                testGridParametersDto) {
        TestGridDto testGridDto
            = testGridService.buildTestGrid(testGridParametersDto);
        return testGridDto;
    }
}