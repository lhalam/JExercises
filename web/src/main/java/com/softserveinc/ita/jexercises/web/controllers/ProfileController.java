package com.softserveinc.ita.jexercises.web.controllers;

import com.softserveinc.ita.jexercises.business.services.CurrentUserService;
import com.softserveinc.ita.jexercises.business.services.UserProfileService;
import com.softserveinc.ita.jexercises.business.services.UserService;
import com.softserveinc.ita.jexercises.common.dto.ResponseDto;
import com.softserveinc.ita.jexercises.common.dto.UserProfileDto;
import com.softserveinc.ita.jexercises.common.utils.DateUtils;
import com.softserveinc.ita.jexercises.web.utils.ResourceNotFoundException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
    private UserService userService;
    @Autowired
    private UserProfileService userProfileService;
    @Autowired
    private CurrentUserService currentUserService;

    /**
     * Getting profile view.
     *
     * @param model UI view model.
     * @return Profile page.
     */
    @RequestMapping(value = "/user/profile", method = RequestMethod.GET)
    public ModelAndView getCurrentUserProfileView(Model model) {
        model.addAttribute("currentUser", true);
        return new ModelAndView("user/profile");
    }

    /**
     * Getting profile view data from User Profile DTO.
     *
     * @return User Profile DTO.
     */
    @RequestMapping(value = "/user/profile", method = RequestMethod.POST)
    @ResponseBody
    public UserProfileDto getCurrentUserProfileData() {
        return userProfileService.getUserInfo(currentUserService
                .getCurrentUser());
    }

    /**
     * Getting user profile view for admin.
     *
     * @param userId User id.
     * @param model  UI view model.
     * @return Profile page.
     * @throws ResourceNotFoundException No user with such id exception.
     */
    @RequestMapping(value = "/user/profile/{userId}",
            method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView getUserProfileNew(@PathVariable Long userId,
                                          Model model)
            throws ResourceNotFoundException {
        if (userService.findUserById(userId) == null) {
            throw new ResourceNotFoundException();
        } else {
            model.addAttribute("currentUser", false);
            model.addAttribute("userId", userId);
            return new ModelAndView("user/profile");
        }
    }

    /**
     * Getting profile view data from User Profile DTO.
     *
     * @param userId User id.
     * @return User Profile DTO.
     */
    @RequestMapping(value = "/user/profile/{userId}",
            method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public UserProfileDto getUserProfileData(@PathVariable Long userId) {
        return userProfileService.getUserInfo(userService.findUserById(userId));
    }

    /**
     * Getting edit profile view.
     *
     * @param model UI view model.
     * @return Profile page.
     */
    @RequestMapping(value = "/user/profile/edit", method = RequestMethod.GET)
    public ModelAndView getCurrentUserEditProfileView(Model model) {
        UserProfileDto user = userProfileService.getUserInfo(currentUserService
                .getCurrentUser());

        model.addAttribute("userFirstName", user.getFirstName());
        model.addAttribute("userLastName", user.getLastName());
        model.addAttribute("userEmail", user.getEmail());
        model.addAttribute("days", DateUtils.getDays());
        model.addAttribute("months", DateUtils.getMonths());
        model.addAttribute("years", DateUtils.getYears());
        model.addAttribute("currentUser", true);

        return new ModelAndView("user/editprofile");
    }

    /**
     * Getting edit profile view for selected user.
     *
     * @param userId User id.
     * @param model UI view model.
     * @return Profile page.
     */
    @RequestMapping(value = "/user/profile/{userId}/edit",
            method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView getUserEditProfileView(@PathVariable Long userId,
                                           Model model) {
        UserProfileDto user = userProfileService.getUserInfo(userService
                .findUserById(userId));

        model.addAttribute("userFirstName", user.getFirstName());
        model.addAttribute("userLastName", user.getLastName());
        model.addAttribute("userEmail", user.getEmail());
        model.addAttribute("days", DateUtils.getDays());
        model.addAttribute("months", DateUtils.getMonths());
        model.addAttribute("years", DateUtils.getYears());
        model.addAttribute("currentUser", false);
        model.addAttribute("userId", userId);

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

        return new ResponseDto();
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
    public byte[] getCurrentUserAvatar() throws IOException {
        byte[] image;

        if (userProfileService.hasAvatar()) {
            image = currentUserService.getCurrentUser().getAvatar();
        } else {
            image = getDefaultAvatar();
        }

        return image;
    }

    /**
     * Gets avatar of user by id.
     *
     * @param userId User id.
     * @return Image byte array.
     * @throws IOException InputStream Exception.
     */
    @RequestMapping(value = "/user/profile/{userId}/avatar",
            method = RequestMethod.GET,
            produces = MediaType.IMAGE_JPEG_VALUE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseBody
    public byte[] getUserAvatar(@PathVariable Long userId) throws IOException {
        byte[] image;

        if (userProfileService.hasAvatar(userId)) {
            image = userService.findUserById(userId).getAvatar();
        } else {
            image = getDefaultAvatar();
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
