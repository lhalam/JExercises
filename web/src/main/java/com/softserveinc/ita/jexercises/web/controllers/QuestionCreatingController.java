package com.softserveinc.ita.jexercises.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
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
    @RequestMapping(value = "/questioncreating", method = RequestMethod.GET)
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
     */
    @RequestMapping(value = "/questioncreating", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void registerNewQuestion(@RequestBody QuestionDto questionDto) {
        questionCreatingService.createQuestionDescription(questionDto);

    }
}
