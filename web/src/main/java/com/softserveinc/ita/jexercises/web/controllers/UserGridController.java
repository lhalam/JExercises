package com.softserveinc.ita.jexercises.web.controllers;

import com.softserveinc.ita.jexercises.business.services.UserGridService;
import com.softserveinc.ita.jexercises.common.dto.GridResponseDto;
import com.softserveinc.ita.jexercises.common.dto.SearchCondition;
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
    public ModelAndView getUsersGridView() {

        return new ModelAndView("user/usergrid");
    }

    /**
     * Getting filtered users profile data.
     *
     * @param searchCondition Filter parameters.
     * @return Filtered data of users.
     */
    @RequestMapping(value = "/user/find", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public GridResponseDto postGridData(@RequestBody SearchCondition searchCondition) {

        return userGridService.getGridRows(searchCondition);
    }
}
