package com.softserveinc.ita.jexercises.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.softserveinc.ita.jexercises.business.services.QuestionDeletingService;

/**
 * Class controls question deleting.
 * 
 * @author Kucheryavenko Dmytro
 *
 * @version 1.0
 */
@Controller
public class QuestionDeletingController {
    /**
     * QuestionDeletingService object.
     */
    @Autowired
    private QuestionDeletingService questionDeletingService;

    /**
     * Calls service to delete question.
     * 
     * @param questionId
     *            ID of question.
     * @return true if request was success.
     */
    @RequestMapping(value = "/question/delete", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public boolean deleteQuestion(@RequestBody Long questionId) {
        questionDeletingService.deleteCurrentQuestion(questionId);
        return true;
    }
}