package com.softserveinc.ita.jexercises.web.controllers;


import com.softserveinc.ita.jexercises.business.services.TestCreatingService;
import com.softserveinc.ita.jexercises.common.dto.GridResponseDto;
import com.softserveinc.ita.jexercises.common.dto.SearchCondition;
import com.softserveinc.ita.jexercises.common.dto.TestCreatingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
     * To set creating of test.
     */
    public static final String CREATE = "create";
    /**
     * To set editing of test.
     */
    public static final String EDIT = "edit";
    /**
     * To set viewing of test.
     */
    public static final String VIEW = "view";
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
    @RequestMapping(value = "/tests/create", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView showTestCreatingPage(Model model) {
        model.addAttribute("toDo",CREATE);
        return new ModelAndView("test/testcreating");
    }

    /**
     * Create new test.
     *
     * @param testCreatingDto info about new test.
     * @return testId of new test.
     */
    @RequestMapping(value = "/tests/create", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public Long saveTest(@RequestBody
                           TestCreatingDto testCreatingDto) {
        return testCreatingService.createTest(testCreatingDto);
    }

    /**
     * Make list of questions.
     *
     * @param searchCondition search conditions.
     * @return searchDto list of question.
     */
    @RequestMapping(value = "/testcreating", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public GridResponseDto showQuestions(@RequestBody
                                       SearchCondition searchCondition) {
        return testCreatingService.getGridRows(searchCondition);
    }

}
