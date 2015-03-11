package com.softserveinc.ita.jexercises.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.softserveinc.ita.jexercises.business.services.TestResultService;
import com.softserveinc.ita.jexercises.common.dto.TestResultDto;

/**
 * Controls Test result page.
 * 
 * @author Volodymyr Lishchynskiy
 * @version 1.0
 */
@Controller
public class TestResultController {
    /**
     * Service which work with DTO.
     */
    @Autowired
    private TestResultService testResultService;

    /**
     * Method provides mapping on "testresult" input.
     *
     * @param model
     *            Model.
     * @param id
     *            Attempt id.
     * @return ModelAndView object,in current case that actually means returning
     *         testresult.jsp
     */
    @RequestMapping(value = "/test/result/{id}", method = RequestMethod.GET)
    public ModelAndView showTestResultPage(@PathVariable("id") Long id,
            Model model) {
        TestResultDto resultInfo = testResultService.getTestResultInfo(id);
        model.addAttribute("firstName", resultInfo.getFirstName());
        model.addAttribute("lastName", resultInfo.getLastName());
        model.addAttribute("testName", resultInfo.getTestName());
        model.addAttribute("date", resultInfo.getDate());
        model.addAttribute("total", resultInfo.getTotalAnswersCount());
        model.addAttribute("correct", resultInfo.getCorrectAnswersCount());
        model.addAttribute("isPublic", resultInfo.isPublic());
        return new ModelAndView("test/testresult");
    }

    /**
     * Method provides mapping on "testresult" input.
     *
     * @param id
     *            Attempt id.
     * @return TestResultDto object with all parameters.
     */
    @RequestMapping(value = "/test/result/{id}", method = RequestMethod.POST)
    @ResponseBody
    public TestResultDto showTestResultInfo(@PathVariable("id") Long id) {
        TestResultDto testResultDto = testResultService.getTestResultInfo(id);
        return testResultDto;
    }
}
