package com.softserveinc.ita.jexercises.web.controllers;

import com.softserveinc.ita.jexercises.business.services.TestCreatingService;
import com.softserveinc.ita.jexercises.common.dto.GridResponseDto;
import com.softserveinc.ita.jexercises.common.dto.TestCreatingDto;
import com.softserveinc.ita.jexercises.common.dto.dataTables.DataTables;
import com.softserveinc.ita.jexercises.common.mapper.DataTablesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
     * Service which maps DataTables SearchCondition.
     */
    @Autowired
    private DataTablesMapper dataTablesMapper;

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
        model.addAttribute("pageAction",CREATE);
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
    public Long createTest(@RequestBody
                           TestCreatingDto testCreatingDto) {
        return testCreatingService.createTest(testCreatingDto);
    }

    /**
     * Update test.
     *
     * @param testCreatingDto info about new test.
     * @param testId to set existing test.
     * @return testId of new test.
     */
    @RequestMapping(value = "/tests/{id}/update", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public Long updateTest(@RequestBody
        TestCreatingDto testCreatingDto, @PathVariable("id") Long testId) {
        return testCreatingService.updateTest(testCreatingDto, testId);
    }

    /**
     * Method provides mapping on "testcreating" input.
     *
     * @param model Model.
     * @return ModelAndView object,in current
     * case that actually means returning.
     * testcreating.jsp
     */
    @RequestMapping(value = "/tests/{id}/edit", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView showTestEditingPage(Model model) {
        model.addAttribute("pageAction",EDIT);
        return new ModelAndView("test/testcreating");
    }

    /**
     * Get info about test.
     *
     * @param testId info about new test.
     * @return testCreatingDto of new test.
     */
    @RequestMapping(value = "/tests/{id}/edit", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public TestCreatingDto infoTest(@PathVariable("id") Long testId) {
        return testCreatingService.infoTest(testId);
    }

    /**
     * Make list of all questions.
     *
     * @param dataTables to set search conditions.
     * @param testId of current test.
     * @return searchDto list of question.
     */
    @RequestMapping(value = "/tests/{id}/all", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public GridResponseDto showAllQuestions(@RequestBody DataTables
        dataTables,@PathVariable("id") Long testId) {
        return testCreatingService.getGridRowsOfAllQuestions(
            dataTablesMapper.toSearchCondition(dataTables), testId);
    }

    /**
     * Make list of added questions.
     *
     * @param dataTables to set search conditions.
     * @param testId of current test.
     * @return searchDto list of question.
     */
    @RequestMapping(value = "/tests/{id}/added", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public GridResponseDto showAddedQuestions(@RequestBody DataTables
        dataTables,@PathVariable("id") Long testId) {
        return testCreatingService.getGridRowsOfAddedQuestions(
                dataTablesMapper.toSearchCondition(dataTables), testId);
    }

    /**
     * Update test adding question.
     *
     * @param questionId to set question.
     * @param testId to set existing test.
     * @return testId.
     */
    @RequestMapping(value = "/tests/{id}/add", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public Long addQuestionToTest(@RequestBody Long questionId, @PathVariable("id") Long testId) {
        testCreatingService.addQuestionToTest(questionId, testId);
        return testId;
    }

    /**
     * Update test removing question.
     *
     * @param questionId to set question.
     * @param testId to set existing test.
     * @return testId.
     */
    @RequestMapping(value = "/tests/{id}/remove", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public Long removeQuestionFromTest(@RequestBody Long questionId, @PathVariable("id") Long testId) {
        testCreatingService.removeQuestionToTest(questionId, testId);
        return testId;
    }

    /**
     * Method provides mapping on "testcreating" input.
     *
     * @param model Model.
     * @return ModelAndView object,in current
     * case that actually means returning.
     * testcreating.jsp
     */
    @RequestMapping(value = "/tests/{id}/view", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView showTestViewingPage(Model model) {
        model.addAttribute("pageAction",VIEW);
        return new ModelAndView("test/testcreating");
    }

    /**
     * Method shows test info.
     *
     * @param testId of current test.
     * @return info about current test viewing.
     */
    @RequestMapping(value = "/tests/{id}/view", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public TestCreatingDto infoViewTest(@PathVariable("id") Long testId) {
        return testCreatingService.infoTest(testId);
    }

}
