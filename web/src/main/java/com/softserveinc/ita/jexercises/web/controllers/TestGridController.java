package com.softserveinc.ita.jexercises.web.controllers;

import com.google.gson.Gson;
import com.softserveinc.ita.jexercises.business.services.TestGridService;
import com.softserveinc.ita.jexercises.common.dto.TestGridDto;
import com.softserveinc.ita.jexercises.common.dto.TestGridParametersDto;
import com.softserveinc.ita.jexercises.common.dto.TestGridRowDto;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * Controls test data table viewing.
 *
 * @author Ihor Demkovych
 * @version 1.0
 */
@Controller
public class TestGridController {

    /**
     * Service which works with Test Grid DTO.
     */
    @Autowired
    private TestGridService testGridService;

    /**
     * Build TestGrid jsp for data table.
     *
     * @return ModelAndView to test grid page.
     */
    @RequestMapping(value = "/testgrid", method = RequestMethod.GET)
    public ModelAndView testgrid() {
        return new ModelAndView("test/testgrid");
    }


    /** There are a problem with SearchCondition during formation testGridDto in TestGridService
     * Build TestGrid data table.
     *
     * @return json.
     */
    @RequestMapping(value = "/testgrid", method = RequestMethod.POST)
    public
    @ResponseBody
    String testGrid(@RequestBody String jsoNRequest) {
        Gson gson = new Gson();
        TestGridParametersDto testGridParametersDto
            = gson.fromJson(jsoNRequest, TestGridParametersDto.class);
        /*TestGridDto testGridDto                            // <- problem is here
            = testGridService.buildAllTestGrid();*/
        TestGridRowDto testGridRowDto = new TestGridRowDto();//
        testGridRowDto.setDescription("Test me");            // Just for test controller
        testGridRowDto.setIsPublic(true);                    //
        return gson.toJson(testGridRowDto);
    }

}


