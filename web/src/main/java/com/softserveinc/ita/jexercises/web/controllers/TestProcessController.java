package com.softserveinc.ita.jexercises.web.controllers;

import com.softserveinc.ita.jexercises.business.services.TestProcessService;
import com.softserveinc.ita.jexercises.business.services.TestService;
import com.softserveinc.ita.jexercises.common.dto.QuestionRequestDto;
import com.softserveinc.ita.jexercises.common.dto.QuestionResponseDto;
import com.softserveinc.ita.jexercises.common.dto.ResponseDto;
import com.softserveinc.ita.jexercises.common.dto.TestStartDto;
import com.softserveinc.ita.jexercises.web.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
     * Getting test process view.
     *
     * @param id Test id.
     * @return Test page.
     * @throws ResourceNotFoundException No test with such id
     *                                   or attempt is not exist.
     */
    @RequestMapping(value = "/test/{id}/process", method = RequestMethod.GET)
    public ModelAndView testForm(@PathVariable("id") Long id)
            throws ResourceNotFoundException {
        if (testService.findTestById(id) == null ||
                !testProcessService.isAttemptExist(id)) {
            throw new ResourceNotFoundException();
        } else {
            return new ModelAndView("test/testinprocess");
        }
    }

    /**
     * Getting test process view data from Test Start DTO.
     *
     * @param id Test id.
     * @return Test Start DTO.
     */
    @RequestMapping(value = "/test/{id}/process", method = RequestMethod.POST)
    @ResponseBody
    public TestStartDto testInformationForm(@PathVariable("id") Long id) {
        return testProcessService.getInformationAboutTestQuestions(id);
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
