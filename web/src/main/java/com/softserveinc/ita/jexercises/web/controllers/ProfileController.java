package com.softserveinc.ita.jexercises.web.controllers;

import com.softserveinc.ita.jexercises.business.services.ProfileService;
import com.softserveinc.ita.jexercises.common.dto.UserDto;
import com.softserveinc.ita.jexercises.common.dto.UserProfileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * Controls process of viewing and editing users profile.
 *
 * @author Taras Vuyiv
 * @version 1.0
 */
@Controller
public class ProfileController {

    /**
     * Final String of Edit Profile .jsp page name.
     */
    private static final String EDIT_PROFILE_JSP = "editprofile";
    /**
     * Final String of Profile .jsp page name.
     */
    private static final String PROFILE_JSP = "profile";
    /**
     * Final String of Edit Profile page path.
     */
    private static final String PROFILE_EDIT_PAGE_PATH = "/edit";
    /**
     * Final String of Profile page path.
     */
    private static final String PROFILE_PAGE_PATH = "/profile";
    /**
     * Final String of User DTO attribute.
     */
    private static final String USER_DTO_ATTRIBUTE = "userDto";
    /**
     * Final String of User First Name attribute.
     */
    private static final String FIRST_NAME_ATTRIBUTE = "userFirstName";
    /**
     * Final String of User Last Name attribute.
     */
    private static final String LAST_NAME_ATTRIBUTE = "userLastName";
    /**
     * Final String of User Email attribute.
     */
    private static final String EMAIL_ATTRIBUTE = "userEmail";
    /**
     * Final String of User Role attribute.
     */
    private static final String ROLE_ATTRIBUTE = "userRole";
    /**
     * Final String of User Registration Date attribute.
     */
    private static final String REG_DATE_ATTRIBUTE = "userRegistrationDate";
    /**
     * Service that handles profile related processes.
     */
    @Autowired
    private ProfileService profileService;

    /**
     * Binds user DTO to profile view.
     *
     * @param model Model from UI.
     * @return Profile page.
     */
    @RequestMapping(value = PROFILE_PAGE_PATH, method = RequestMethod.GET)
    public ModelAndView getProfile(Model model) {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        String userEmail = auth.getName();

        UserProfileDto user = profileService.getUserInfo(userEmail);

        model.addAttribute(FIRST_NAME_ATTRIBUTE, user.getFirstName());
        model.addAttribute(LAST_NAME_ATTRIBUTE, user.getLastName());
        model.addAttribute(REG_DATE_ATTRIBUTE,
                user.getRegistrationDate());
        model.addAttribute(EMAIL_ATTRIBUTE, user.getEmail());
        model.addAttribute(ROLE_ATTRIBUTE, user.getRole());

        return new ModelAndView(PROFILE_JSP);
    }

    /**
     * Binds user DTO to edit profile view.
     *
     * @param model Model from UI.
     * @return Edit Profile page.
     */
    @RequestMapping(value = PROFILE_EDIT_PAGE_PATH, method = RequestMethod.GET)
    public String getEdit(Model model) {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        String userEmail = auth.getName();

        UserProfileDto user = profileService.getUserInfo(userEmail);

        UserDto userDto = new UserDto();
        model.addAttribute(USER_DTO_ATTRIBUTE, userDto);

        model.addAttribute(FIRST_NAME_ATTRIBUTE, user.getFirstName());
        model.addAttribute(LAST_NAME_ATTRIBUTE, user.getLastName());
        model.addAttribute(EMAIL_ATTRIBUTE, user.getEmail());

        return EDIT_PROFILE_JSP;
    }

    /**
     * Starts process of user profile data update.
     *
     * @param userDto User DTO Object.
     * @return Profile page.
     */
    @RequestMapping(value = PROFILE_EDIT_PAGE_PATH, method = RequestMethod.POST)
    public ModelAndView saveEdit(@ModelAttribute(USER_DTO_ATTRIBUTE)
                                 UserDto userDto) {

        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        String userEmail = auth.getName();

        userDto.setEmail(userEmail);
        profileService.updateUserProfile(userDto);

        return new ModelAndView(EDIT_PROFILE_JSP);
    }


}
