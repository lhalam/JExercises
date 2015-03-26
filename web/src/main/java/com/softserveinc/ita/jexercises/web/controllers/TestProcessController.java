package com.softserveinc.ita.jexercises.web.controllers;

import com.softserveinc.ita.jexercises.business.services.TestDescriptionService;
import com.softserveinc.ita.jexercises.business.services.TestProcessService;
import com.softserveinc.ita.jexercises.business.services.TestService;
import com.softserveinc.ita.jexercises.common.dto.QuestionRequestDto;
import com.softserveinc.ita.jexercises.common.dto.QuestionResponseDto;
import com.softserveinc.ita.jexercises.common.dto.ResponseDto;
import com.softserveinc.ita.jexercises.common.dto.TestStartDto;
import com.softserveinc.ita.jexercises.web.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controls test process page.
 *
 * @author Volodymyr Yakymiv
 * @version 1.0
 */
@Controller
public class TestProcessController {

    /**
     * Service that handles test process.
     */
    @Autowired
    private TestProcessService testProcessService;

    /**
     * Service which gives test object.
     */
    @Autowired
    private TestService testService;

    /**
     * Service that handles get test description process.
     */
    @Autowired
    private TestDescriptionService testDescriptionService;

    /**
     * Getting test process view.
     *
     * @param model UI view model.
     * @param testId    Test id.
     * @return Test page.
     * @throws ResourceNotFoundException No test with such id
     * or user does not have access to private test
     */
    @RequestMapping(value = "/test/process/{id}", method = RequestMethod.GET)
    public ModelAndView testForm(Model model, @PathVariable("id") Long testId)
            throws ResourceNotFoundException {
        if (testService.findTestById(testId) == null ||
                !testDescriptionService.checkDoesUserHavePrivateLink(testId)) {
            throw new ResourceNotFoundException();
        } else {
            return new ModelAndView("test/testinprocess");
        }
    }

    /**
     * Getting test process view data from Test Start DTO.
     *
     * @param testId Test id.
     * @return Test Start DTO.
     */
    @RequestMapping(value = "/test/process/{id}", method = RequestMethod.POST)
    @ResponseBody
    public TestStartDto testForm(@PathVariable("id") Long testId) {
        return testProcessService.getInformationAboutTestQuestions(testId);
    }

    /**
     * Getting test process view data from Question Response DTO.
     *
     * @param questionRequestDto questionRequestDto object.
     * @return Question Response DTO.
     */
    @RequestMapping(value = "/test/process", method = RequestMethod.POST)
    @ResponseBody
    public QuestionResponseDto testProcessingForm(
            @RequestBody QuestionRequestDto questionRequestDto) {
        return testProcessService.getQuestion(questionRequestDto);
    }

    /**
     * Method calls service-methods to check user answers.
     *
     * @param questionRequestDto questionRequestDto object.
     * @return boolean true.
     */
    @RequestMapping(value = "/test/process/submit",
            method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto testSubmitForm(
            @RequestBody QuestionRequestDto questionRequestDto) {
        testProcessService.submitTest(questionRequestDto);
        return new ResponseDto();
    }
}
