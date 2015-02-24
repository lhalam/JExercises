package com.softserveinc.ita.jexercises.web.controllers;

import com.softserveinc.ita.jexercises.business.services.TestGridService;
import com.softserveinc.ita.jexercises.common.dto.SearchParametersDto;
import com.softserveinc.ita.jexercises.common.dto.SearchGridDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;


/**
 * Controls Test result page.
 *
 * @author Ihor Demkovych
 * @version 1.0
 */
@Controller
public class TestGridController {
    /**
     * Service which work with DTO.
     */
    @Autowired
    private TestGridService testGridService;

    /**
     * Method provides mapping on "testgrid" input
     *
     * @param model Model.
     * @return ModelAndView object,in current
     *                            case that actually means returning.
     * testgrid.jsp
     */
    @RequestMapping(value = "/testgrid", method = RequestMethod.GET)
    public ModelAndView showTestGridPage(Model model) {

        return new ModelAndView("test/testgrid");
    }

    /**
     * Make TestGrid.
     *
     * @param request to rebuild new table.
     * @return TestGridDto object.
     */
    @RequestMapping(value = "/testgrid", method = RequestMethod.POST)
    @ResponseBody
    public SearchGridDto showTestGridPage(HttpServletRequest request) {

        SearchParametersDto searchParametersDto = new SearchParametersDto();
        searchParametersDto.setDraw(
            Integer.parseInt(request.getParameter("draw")));
        searchParametersDto.setSearchKey(
            request.getParameter("search[value]"));
        searchParametersDto.setOrder(
            request.getParameter("order[0][dir]"));
        searchParametersDto.setPagenumber(
            Integer.parseInt(request.getParameter("start")));
        searchParametersDto.setPagesize(
            Integer.parseInt(request.getParameter("length")));
        SearchGridDto searchGridDto
            = testGridService.buildTestGrid(searchParametersDto);
        return searchGridDto;
    }
}