package com.softserveinc.ita.jexercises.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Class which includes CreateQuestionController.
 * 
 * @author Kucheryavenko Dmytro
 *
 * @version 1.0
 */
@Controller
public class CreateQuestionController {
    /**
     * Method provides mapping on "createquestion" input
     * 
     * @return createquestion.jsp
     */
    @RequestMapping(value = "/createquestion", method = RequestMethod.GET)
    public String printCreateQuestion() {
        return "createquestion";
    }
}
