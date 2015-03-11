package com.softserveinc.ita.jexercises.web.controllers;

import com.softserveinc.ita.jexercises.business.services.UserGridService;
import com.softserveinc.ita.jexercises.common.dto.GridResponseDto;
import com.softserveinc.ita.jexercises.common.dto.dataTables.DataTables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controls process of viewing users DataTable.
 *
 * @author Taras Vuyiv
 */
@Controller
public class UserGridController {

    @Autowired
    private UserGridService userGridService;

    /**
     * Get view of users DataTable.
     *
     * @return Users DataTable page.
     */
    @RequestMapping(value = "/user/find", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView getGridOfUsersView() {

        return new ModelAndView("user/usergrid");
    }

    /**
     * Getting filtered users profile data.
     *
     * @param dataTables Grid parameters.
     * @return Filtered data of users.
     */
    @RequestMapping(value = "/user/find", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public GridResponseDto postGridOfUsersData(
            @RequestBody DataTables dataTables) {

        return userGridService.getUsers(dataTables);
    }

    /**
     * Get view of user attempts.
     *
     * @return Page with attempts DataTable.
     */
    @RequestMapping(value = "/user/attempts", method = RequestMethod.GET)
    public ModelAndView getGridOfCurrentUserAttemptsView() {

        return new ModelAndView("user/attemptsgrid");
    }

    /**
     * Getting filtered user attempts data.
     *
     * @param dataTables Grid parameters.
     * @return Filtered user attempts.
     */
    @RequestMapping(value = "/user/attempts", method = RequestMethod.POST)
    @ResponseBody
    public GridResponseDto postCurrentUserAttemptsData(
            @RequestBody DataTables dataTables) {

        return userGridService.getCurrentUserAttempts(dataTables);
    }

}
