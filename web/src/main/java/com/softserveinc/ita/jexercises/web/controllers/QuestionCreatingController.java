package com.softserveinc.ita.jexercises.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.softserveinc.ita.jexercises.business.services.QuestionCreatingService;
import com.softserveinc.ita.jexercises.common.dto.QuestionDto;

/**
 * Class which includes CreateQuestionController.
 * 
 * @author Kucheryavenko Dmytro
 *
 * @version 1.0
 */
@Controller
public class QuestionCreatingController {
    /**
     * Service handles question creating process.
     */
    @Autowired
    private QuestionCreatingService questionCreatingService;

    /**
     * Gets Question Creating page.
     * 
     * @param model
     *            Model object.
     * @return questioncreating.jsp
     */
    @RequestMapping(value = "/question/create/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView showCreateQuestionForm(Model model) {
        return new ModelAndView("questioncreating");
    }

    /**
     * Method calls service to put data into Question and Assert tables in
     * database.
     * 
     * @param questionDto
     *            QuestionDto object.
     * @param testId
     *            of current test.
     * @return testId of current test.
     */
    @RequestMapping(value = "/question/create/{id}", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public Long registerNewQuestion(@RequestBody QuestionDto questionDto,
            @PathVariable("id") Long testId) {
        questionCreatingService.createQuestionDescription(questionDto, testId);
        return (testId);
    }

    /**
     * Method gets page for question editing.
     * 
     * @param model
     *            object.
     * @return questioncreating.jsp.
     */
    @RequestMapping(value = "/test/{idTest}/question/edit/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public ModelAndView showTestEditingPage(Model model) {
        return new ModelAndView("questioncreating");
    }

    /**
     * Method gets QuestionDto object.
     * 
     * @param questionId
     *            question ID.
     * @return QuestionDto object.
     */
    @RequestMapping(value = "/test/{idTest}/question/edit/{id}", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public QuestionDto sendQuestionId(@PathVariable("id") Long questionId) {
        return questionCreatingService.getQuestionDescription(questionId);
    }

    /**
     * Method updates question.
     * 
     * @param questionDto
     *            question DTO.
     * @param questionId
     *            question ID.
     */
    @RequestMapping(value = "/test/{idTest}/question/edit/{idQuestion}/update", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public void updateQuestion(@RequestBody QuestionDto questionDto,
            @PathVariable("idQuestion") Long questionId) {
        questionCreatingService.updateQuestion(questionDto, questionId);

    }
}
