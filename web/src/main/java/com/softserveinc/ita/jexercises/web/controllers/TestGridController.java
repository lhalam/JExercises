package com.softserveinc.ita.jexercises.web.controllers;

import com.softserveinc.ita.jexercises.business.services.TestGridService;
import com.softserveinc.ita.jexercises.common.dto.SearchParametersDto;
import com.softserveinc.ita.jexercises.common.dto.SearchGridDto;
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
     * Method provides mapping on "testsGrid" input.
     *
     * @param model Model.
     * @return ModelAndView object,in current
     *                            case that actually means returning.
     * testsGrid.jsp
     */
    @RequestMapping(value = "/testsgrid", method = RequestMethod.GET)
    public ModelAndView showTestGridPage(Model model) {

        return new ModelAndView("test/testsgrid");
    }

    /**
     * Make Tests Grid.
     *
     * @param searchParametersDto to rebuild new table.
     * @return TestGridDto object.
     */
    @RequestMapping(value = "/testsgrid", method = RequestMethod.POST)
    @ResponseBody
    public SearchGridDto showTestGridPage(@RequestBody
                                          SearchParametersDto searchParametersDto) {
        SearchGridDto searchGridDto
            = testGridService.buildTestGrid(searchParametersDto);
        return searchGridDto;
    }

    /**
     * Make Tests Grid.
     *
     * @param testId of test which will be deleted.
     */
    @RequestMapping(value = "/testdelete", method = RequestMethod.POST)
    @ResponseBody
    public String showTestGridPage(@RequestBody Long testId) {
        testGridService.delete(testId);
        return testId.toString();
    }

}
