package com.softserveinc.ita.jexercises.web.controllers;


import com.softserveinc.ita.jexercises.business.services.TestCreatingService;
import com.softserveinc.ita.jexercises.common.dto.GridResponseDto;
import com.softserveinc.ita.jexercises.common.dto.SearchCondition;
import com.softserveinc.ita.jexercises.common.dto.TestCreatingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controls Test creating page.
 *
 * @author Ihor Demkovych
 * @version 1.0
 */
@Controller
public class TestCreatingController {
    /**
     * Service which work with DTO.
     */
    @Autowired
    private TestCreatingService testCreatingService;

    /**
     * Method provides mapping on "testcreating" input.
     *
     * @param model Model.
     * @return ModelAndView object,in current
     * case that actually means returning.
     * testcreating.jsp
     */
    @RequestMapping(value = "/testcreating", method = RequestMethod.GET)
    public ModelAndView showTestCreatingPage(Model model) {

        return new ModelAndView("test/testcreating");
    }

    /**
     * Make list of questions.
     *
     * @param searchCondition search conditions.
     * @return searchDto list of question.
     */
    @RequestMapping(value = "/testcreating", method = RequestMethod.POST)
    @ResponseBody
    public GridResponseDto showQuestions(@RequestBody
                                       SearchCondition searchCondition) {
        return testCreatingService.getGridRows(searchCondition);
    }

    /**
     * Save new test.
     *
     * @param testCreatingDto info about new test.
     * @return String object.
     */
    @RequestMapping(value = "/testcreating/save", method = RequestMethod.POST)
    @ResponseBody
    public String saveTest(@RequestBody
                           TestCreatingDto testCreatingDto) {
        testCreatingService.newTest(testCreatingDto);
        return testCreatingDto.getTestName();
    }

}
