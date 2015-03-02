package com.softserveinc.ita.jexercises.web.controllers;

import com.softserveinc.ita.jexercises.business.services.CurrentUserService;
import com.softserveinc.ita.jexercises.business.services.UserProfileService;
import com.softserveinc.ita.jexercises.common.dto.UserProfileDto;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Controls process of viewing and editing user profiles.
 *
 * @author Taras Vuyiv
 */
@Controller
public class ProfileController {

    @Autowired
    private UserProfileService userProfileService;
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
     * Getting new user data and updating his profile.
     *
     * @param userProfileDto User Profile DTO.
     * @return Status.
     */
    @RequestMapping(value = "/user/profile/edit", method = RequestMethod.POST)
    @ResponseBody
    public String updateUserProfile(UserProfileDto userProfileDto) {
        userProfileService.updateUserProfile(userProfileDto);

        return "{\"status\": \"success\"}";
    }

    /**
     * Gets byte array from uploaded picture.
     *
     * @param file Uploaded image.
     * @return Json with image as String.
     * @throws IOException InputStream error.
     */
    @RequestMapping(value = "/post/avatar/*",
            produces = "application/json",
            method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> uploadUserAvatar(
            @RequestParam("filedata") MultipartFile file)
            throws IOException {

        byte[] avatar = file.getBytes();

        Map<String, String> avatarMap = new HashMap<>();
        avatarMap.put("image", Base64.encodeBase64String(avatar));

        return avatarMap;
    }

    /**
     * Gets avatar of current user.
     *
     * @param response Response.
     * @throws IOException InputStream Exception.
     */
    @RequestMapping(value = "/user/profile/avatar",
            method = RequestMethod.GET)
    @ResponseBody
    public void getUserAvatar(HttpServletResponse response) throws IOException {
        byte[] image;

        if (userProfileService.hasAvatar()) {
            image = currentUserService.getCurrentUser().getAvatar();
        } else {
            image = getDefaultAvatar();
        }

        response.reset();
        response.setContentType("image/jpeg");
        response.setContentLength(image.length);
        response.getOutputStream().write(image);
    }

    private byte[] getDefaultAvatar() {
        byte[] image = null;
        String picturePath = Paths.get("").toAbsolutePath().toString() +
                "\\web\\src\\main\\webapp\\resources" +
                "\\no-avatar.png";

        Path path = Paths.get(picturePath);
            try {
            image = Files.readAllBytes(path);
        } catch (IOException e) {
            System.out.println("Input error.");
        }

        return image;
    }
}
