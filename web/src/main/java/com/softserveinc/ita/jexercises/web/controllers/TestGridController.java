package com.softserveinc.ita.jexercises.web.controllers;

import com.softserveinc.ita.jexercises.business.services.UserRegistrationService;
import com.softserveinc.ita.jexercises.business.utils.EmailExistsException;
import com.softserveinc.ita.jexercises.common.dto.TestGridDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controls viewing test datatable
 *
 * @author Ihor Demkovych
 * @version 1.0
 */
@Controller
public class TestGridController {

    /**
     * Method provides mapping on "testgrid" input
     *
     * @return ModelAndView object,in current case that actually means returning
     *         testgrid.jsp
     */
    @RequestMapping(value = "/testgrid", method = RequestMethod.GET)
    public ModelAndView testgrid() {
        return new ModelAndView("testgrid");
    }
}