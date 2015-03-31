package com.softserveinc.ita.jexercises.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.softserveinc.ita.jexercises.business.services.AttemptGridService;
import com.softserveinc.ita.jexercises.business.services.CurrentUserService;
import com.softserveinc.ita.jexercises.business.services.TestService;
import com.softserveinc.ita.jexercises.common.dto.GridResponseDto;
import com.softserveinc.ita.jexercises.common.dto.SearchCondition;
import com.softserveinc.ita.jexercises.common.dto.dataTables.DataTables;
import com.softserveinc.ita.jexercises.common.entity.Test;
import com.softserveinc.ita.jexercises.common.mapper.DataTablesMapper;
import com.softserveinc.ita.jexercises.common.utils.Role;
import com.softserveinc.ita.jexercises.web.utils.ResourceNotFoundException;

/**
 * Controls process of viewing test attempts DataTable.
 * 
 * @author Volodymyr Lishchynskiy
 * @version 1.0
 */
@Controller
public class AttemptGridController {

    @Autowired
    private AttemptGridService attemptGridService;

    @Autowired
    private DataTablesMapper dataTablesMapper;

    @Autowired
    private TestService testService;

    @Autowired
    private CurrentUserService currentUserService;

    /**
     * Get view of concrete test attempts.
     * 
     * @param model
     *            Model
     * @param id
     *            Test id.
     * @return page with test attempts datatable.
     */
    @RequestMapping(value = "/attempts/{id}", method = RequestMethod.GET)
     public ModelAndView getGridOfTestAttempts(Model model, @PathVariable("id") Long id)
            throws ResourceNotFoundException {
        Test test = testService.findTestById(id);
        if (testService.findTestById(id) == null) {
            throw new ResourceNotFoundException();
        } else {
            model.addAttribute("testName", test.getName());
            return new ModelAndView("test/attempts");
        }
    }

    /**
     * Get filtered test attempts data.
     * 
     * @param id
     *            Test id.
     * @param dataTables
     *            Grid parameters.
     * @return Filtered test attempts.
     */
    @RequestMapping(value = "/attempts/{id}", method = RequestMethod.POST)
    @ResponseBody
    public GridResponseDto testAttemptsData(@RequestBody DataTables dataTables,
            @PathVariable Long id) {
        dataTables.getColumns().get(1).setData("user.firstName");
        dataTables.getColumns().get(2).setData("user.lastName");
        SearchCondition searchCondition = dataTablesMapper
                .toSearchCondition(dataTables);
        if (currentUserService.getCurrentUser().getRole() == Role.ROLE_USER) {
            searchCondition.getAndFilterMap().put("user.id",
			currentUserService.getCurrentUser().getId());
            searchCondition.getNotFilterMap().put("test.isPublic", false);
        }
        searchCondition.getAndFilterMap().put("test.id", id);
        return attemptGridService.getUserAttempts(searchCondition);
    }
}