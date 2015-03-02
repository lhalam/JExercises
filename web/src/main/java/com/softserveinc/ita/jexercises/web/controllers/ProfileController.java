package com.softserveinc.ita.jexercises.web.controllers;

import com.softserveinc.ita.jexercises.business.services.CurrentUserService;
import com.softserveinc.ita.jexercises.business.services.UserProfileService;
import com.softserveinc.ita.jexercises.common.dto.ResponseDto;
import com.softserveinc.ita.jexercises.common.dto.UserProfileDto;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Controls process of viewing and editing user profiles.
 *
 * @author Taras Vuyiv
 */
@Controller
public class ProfileController {

    private static final String DEFAULT_AVATAR_PICTURE_NAME = "no-avatar.png";
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
     * @return User Profile DTO.
     */
    @RequestMapping(value = "/user/profile", method = RequestMethod.POST)
    @ResponseBody
    public UserProfileDto getProfileData() {
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
    public ModelAndView getEditProfileView(Model model) {
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
    public ResponseDto updateUserProfile(UserProfileDto userProfileDto) {
        userProfileService.updateUserProfile(userProfileDto);

        ResponseDto response = new ResponseDto();
        response.setSuccess(true);

        return response;
    }

    /**
     * Gets byte array from uploaded picture.
     *
     * @param file Uploaded image.
     * @return Json with image as String.
     * @throws IOException InputStream error.
     */
    @RequestMapping(value = "/post/avatar/*", method = RequestMethod.POST)
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
     * @return Image byte array.
     * @throws IOException InputStream Exception.
     */
    @RequestMapping(value = "/user/profile/avatar", method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getUserAvatar() throws IOException {
        byte[] image;

        if (userProfileService.hasAvatar()) {
            image = currentUserService.getCurrentUser().getAvatar();
        } else {
            image = getDefaultAvatar();
        }

        return image;
    }

    private byte[] getDefaultAvatar() throws IOException {

        InputStream inputStream =
                getClass().getClassLoader()
                        .getResourceAsStream(DEFAULT_AVATAR_PICTURE_NAME);

        return IOUtils.toByteArray(inputStream);
    }
}
