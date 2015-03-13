package com.softserveinc.ita.jexercises.web.controllers;

import com.softserveinc.ita.jexercises.business.services.TestGridService;
import com.softserveinc.ita.jexercises.common.dto.GridResponseDto;
import com.softserveinc.ita.jexercises.common.dto.dataTables.DataTables;
import com.softserveinc.ita.jexercises.common.mapper.DataTablesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controls Tests Grid page.
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
     * Service which maps DataTables SearchCondition.
     */
    @Autowired
    private DataTablesMapper dataTablesMapper;

    /**
     * Method provides mapping on "testsGrid" input.
     *
     * @param model Model.
     * @return ModelAndView object,in current
     * case that actually means returning.
     * testsGrid.jsp
     */
    @RequestMapping(value = "/testsgrid", method = RequestMethod.GET)
    public ModelAndView showTestGridPage(Model model) {

        return new ModelAndView("test/testsgrid");
    }

    /**
     * Make Tests Grid.
     *
     * @param dataTables search conditions.
     * @return TestGridDto object.
     */
    @RequestMapping(value = "/testsgrid", method = RequestMethod.POST)
    @ResponseBody
    public GridResponseDto showTestGridPage(@RequestBody
                                            DataTables dataTables) {
        return testGridService.getGridRows(
            dataTablesMapper.toSearchCondition(dataTables));
    }

    /**
     * Make Tests Grid.
     *
     * @param testId of test which will be deleted.
     * @return test Id.
     */
    @RequestMapping(value = "/testsgrid/delete", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public String deleteTest(@RequestBody Long testId) {
        testGridService.delete(testId);
        return testId.toString();
    }

}

