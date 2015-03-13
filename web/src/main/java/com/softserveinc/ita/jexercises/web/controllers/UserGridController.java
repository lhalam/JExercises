package com.softserveinc.ita.jexercises.web.controllers;

import com.softserveinc.ita.jexercises.business.services.AttemptGridService;
import com.softserveinc.ita.jexercises.business.services.CurrentUserService;
import com.softserveinc.ita.jexercises.business.services.UserGridService;
import com.softserveinc.ita.jexercises.business.services.UserService;
import com.softserveinc.ita.jexercises.common.dto.GridResponseDto;
import com.softserveinc.ita.jexercises.common.dto.SearchCondition;
import com.softserveinc.ita.jexercises.common.dto.dataTables.DataTables;
import com.softserveinc.ita.jexercises.common.entity.User;
import com.softserveinc.ita.jexercises.common.mapper.DataTablesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private UserService userService;

    @Autowired
    private DataTablesMapper dataTablesMapper;

    @Autowired
    private AttemptGridService attemptGridService;
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
        dataTables.getColumns().get(4).setData("createdDate");
        SearchCondition searchCondition =
                dataTablesMapper.toSearchCondition(dataTables);

        return userGridService.getUsers(searchCondition);
    }

    /**
     * Get view of current user attempts.
     *
     * @param model View model.
     * @return Page with attempts DataTable.
     */
    @RequestMapping(value = "/user/attempts", method = RequestMethod.GET)
    public ModelAndView getGridOfCurrentUserAttemptsView(Model model) {
        model.addAttribute("currentUser", true);
        return new ModelAndView("user/attemptsgrid");
    }

    /**
     * Getting filtered current user attempts data.
     *
     * @param dataTables Grid parameters.
     * @return Filtered user attempts.
     */
    @RequestMapping(value = "/user/attempts", method = RequestMethod.POST)
    @ResponseBody
    public GridResponseDto postCurrentUserAttemptsData(
            @RequestBody DataTables dataTables) {

        dataTables.getColumns().get(1).setData("test.name");

        SearchCondition searchCondition =
                dataTablesMapper.toSearchCondition(dataTables);

        return attemptGridService.getUserAttempts(
                currentUserService.getCurrentUser().getId(), null,
                searchCondition);
    }

    /**
     * Get view of user attempts.
     *
     * @param model View model.
     * @param id User id.
     * @return Page with attempts DataTable.
     */
    @RequestMapping(value = "/user/{id}/attempts", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView getGridOfUserAttemptsView(Model model,
                                                  @PathVariable Long id) {
        User user = userService.findUserById(id);

        model.addAttribute("userName", user.getFirstName() + " "
                + user.getLastName());
        model.addAttribute("currentUser", false);
        model.addAttribute("userId", id);
        return new ModelAndView("user/attemptsgrid");
    }

    /**
     * Getting filtered user attempts data.
     *
     * @param id User id.
     * @param dataTables Grid parameters.
     * @return Filtered user attempts.
     */
    @RequestMapping(value = "/user/{id}/attempts", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public GridResponseDto postUserAttemptsData(@PathVariable Long id,
                                                @RequestBody DataTables dataTables) {

        dataTables.getColumns().get(1).setData("test.name");

        SearchCondition searchCondition =
                dataTablesMapper.toSearchCondition(dataTables);

        return attemptGridService.getUserAttempts(id, null,
                searchCondition);
    }

}
