package com.softserveinc.ita.jexercises.web.controllers;

import com.softserveinc.ita.jexercises.business.services.CurrentUserService;
import com.softserveinc.ita.jexercises.business.services.UserProfileService;
import com.softserveinc.ita.jexercises.common.dto.UserProfileDto;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Controls process of viewing and editing user profiles.
 *
 * @author Taras Vuyiv
 * @version 1.0
 */
@Controller
public class ProfileController {

    /**
     * Service that handles profile related processes.
     */
    @Autowired
    private UserProfileService userProfileService;
    /**
     * Service for getting current user from SecurityContext.
     */
    @Autowired
    private CurrentUserService currentUserService;

    /**
     * Getting profile view.
     *
     * @return Profile page.
     */
    @RequestMapping(value = "/user/profile", method = RequestMethod.GET)
    public ModelAndView getProfileNew() {
        return new ModelAndView("user/profile");
    }

    /**
     * Getting profile view data from User Profile DTO.
     *
     * @return User Profile DTO type JSON.
     */
    @RequestMapping(value = "/user/profile", method = RequestMethod.POST,
            headers = "Accept=application/json")
    @ResponseBody
    public UserProfileDto getProfileDataJSON() {
        return userProfileService.getUserInfo(currentUserService
                .getCurrentUser());
    }

    /**
     * Getting edit profile view.
     *
     * @param model UI view model.
     * @return Profile page.
     */
    @RequestMapping(value = "/user/profile/edit", method = RequestMethod.GET)
    public ModelAndView getEditProfileNew(Model model) {
        UserProfileDto user = userProfileService.getUserInfo(currentUserService
                .getCurrentUser());

        model.addAttribute("userFirstName", user.getFirstName());
        model.addAttribute("userLastName", user.getLastName());
        model.addAttribute("userEmail", user.getEmail());

        return new ModelAndView("user/editprofile");
    }

    /**
     * Starts process of user profile data update.
     *
     * @param model User Profile DTO Object.
     * @return Profile page.
     */
    @RequestMapping(value = "/user/profile/edit", method = RequestMethod.POST)
    @ResponseBody
    public UserProfileDto postEditProfileDataJSON(UserProfileDto model) {
        userProfileService.updateUserProfile(model);

        return model;
    }

    /**
     * Gets byte array from uploaded picture.
     *
     * @param request Request data.
     * @return Json with image as String.
     * @throws IOException InputStream error.
     */
    @RequestMapping(value = "/user/profile/avatar/*",
            produces = "application/json",
            method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> postUserAvatar(
            final HttpServletRequest request)
            throws IOException {

        InputStream inputStream = request.getInputStream();

        byte[] avatar = IOUtils.toByteArray(inputStream);

        Map<String, String> avatarMap = new HashMap<>();
        avatarMap.put("image", new String(avatar));

        return avatarMap;
    }

    /**
     * Gets current user avatar.
     *
     * @return Image byte array converted to string.
     */
    @RequestMapping(value = "/user/profile/avatar",
            method = RequestMethod.GET)
    @ResponseBody
    public String getUserAvatar() {
        if (userProfileService.hasAvatar()) {
            return new String(currentUserService.getCurrentUser().getAvatar());
        } else {

            String workingDir = System.getProperty("user.dir");
            File file = new File(workingDir +
                    "\\web\\src\\main\\webapp\\resources\\no-avatar.png");
            byte[] image = new byte[(int) file.length()];
            FileInputStream fileInputStream;

            try {
                fileInputStream = new FileInputStream(file);
                fileInputStream.read(image);
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return new String(image);
        }
    }


}
