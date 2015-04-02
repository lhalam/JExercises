package com.softserveinc.ita.jexercises.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softserveinc.ita.jexercises.business.services.CurrentUserService;
import com.softserveinc.ita.jexercises.common.dto.AccountMenuDto;
import com.softserveinc.ita.jexercises.common.entity.User;

/**
 * Controls account menu populating.
 * 
 * @author Oksana Senchuk
 * @version 1.0
 */
@Controller
public class AccountMenuController {

    /**
     * Instance of CurrentUserService.
     */
    @Autowired
    private CurrentUserService currentUserService;

    /**
     * Gets current user information to populate account menu.
     *
     * @param model
     *            AccountMenuDto.
     * @return AccontMenuDto.
     */
    @RequestMapping(value = "/account/menu", method = RequestMethod.POST)
    @ResponseBody
    public AccountMenuDto getAccountInfo(AccountMenuDto model) {
        User user = currentUserService.getCurrentUser();
        model.setFirstName(user.getFirstName());
        model.setLastName(user.getLastName());
        return model;
    }

}
