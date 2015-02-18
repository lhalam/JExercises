package com.softserveinc.ita.jexercises.web.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@Autowired
    TestResultService testResultService;

    /**
     * Method provides mapping on "testresult" input
     *
     * @return ModelAndView object,in current case that actually means returning
     *         testresult.jsp
     */   
   @RequestMapping(value = "/testresult", method = RequestMethod.GET)
    public ModelAndView showTestResultPage(Model model) {
        TestResultDto testResultDto = testResultService.getTestResultInfo(1L) ;
        model.addAttribute("attempt",testResultDto);        
        return new ModelAndView("testresult");
    }
}
