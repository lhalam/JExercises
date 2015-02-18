package com.softserveinc.ita.jexercises.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.softserveinc.ita.jexercises.business.services.
        QuestionCreatingService;
import com.softserveinc.ita.jexercises.common.dto.QuestionCreatingDto;

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
     * Method binds QuestionCreating DTO and question creating form.
     * 
     * @param model
     *            Model object.
     * @return questioncreating.jsp
     */
    @RequestMapping(value = "/questioncreating", method = RequestMethod.GET)
    public ModelAndView showCreateQuestionForm(Model model) {
        QuestionCreatingDto questionCreatingDto = new QuestionCreatingDto();
        model.addAttribute("qc", questionCreatingDto);
        return new ModelAndView("questioncreating");
    }

    /**
     * Method calls service-methods to create tables in database.
     * 
     * @param questionCreatingDto
     *            QuestionCreatingDto object.
     * @return success.jsp
     */
    @RequestMapping(value = "/questioncreating", method = RequestMethod.POST)
    public ModelAndView registerNewQuestion(
            @ModelAttribute("qc") QuestionCreatingDto questionCreatingDto) {
        questionCreatingService.createQuestionDescription(questionCreatingDto);
        questionCreatingService.createExpectedAnswer(questionCreatingDto);
        return new ModelAndView("success");

    }
}
