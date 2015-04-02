package com.softserveinc.ita.jexercises.web.controllers;

import com.softserveinc.ita.jexercises.business.services.TestDescriptionService;
import com.softserveinc.ita.jexercises.business.services.TestService;
import com.softserveinc.ita.jexercises.common.dto.ResponseDto;
import com.softserveinc.ita.jexercises.common.dto.TestDescriptionDto;
import com.softserveinc.ita.jexercises.common.utils.Role;
import com.softserveinc.ita.jexercises.web.utils.AccessDeniedException;
import com.softserveinc.ita.jexercises.web.utils.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Controls test description page.
 *
 * @author Volodymyr Yakymiv
 * @version 1.0
 */
@Controller
public class TestDescriptionController {
    /**
     * Service that handles get test description process.
     */
    @Autowired
    private TestDescriptionService testDescriptionService;

    /**
     * Service which gives test object.
     */
    @Autowired
    private TestService testService;

    /**
     * Gets test description form page.
     *
     * @param id      Test id.
     * @param request HttpServletRequest.
     * @return Test Description page.
     */
    @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
    public ModelAndView showTestDescriptionForm(@PathVariable("id") Long id,
                                                HttpServletRequest request){
        if (testService.findTestById(id) == null ) {
            throw new ResourceNotFoundException();
        }
        if(!isAccessAllowed(request, id)){
        	 throw new AccessDeniedException();
          }
        return new ModelAndView("test/testdescription");
    }

    /**
     * Getting test description data from Test Description DTO.
     *
     * @param id test id.
     * @return TestDescriptionDto object.
     */
    @RequestMapping(value = "/test/{id}", method = RequestMethod.POST)
    @ResponseBody
    public TestDescriptionDto showTestDescriptionForm(@PathVariable("id") Long id) {
        return testDescriptionService.getTestDescription(id);
    }

    /**
     * Creates attempt and user answers.
     *
     * @param id test id.
     * @return Response DTO object.
     */
    @RequestMapping(value = "/test/{id}/start", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto startTest(@PathVariable("id") Long id) {
        testDescriptionService.createAttempt(id);
        return new ResponseDto();
    }

    /**
     * Checks does user have access to private test.
     *
     * @param request HttpServletRequest.
     * @param testId  Test id.
     * @return true if test is public, user has public link or user has role admin.
     */
    private boolean isAccessAllowed(HttpServletRequest request, Long testId) {
		String url = (String) request.getAttribute("publicLink");
		String requestUrl = (String) request
				.getAttribute("javax.servlet.forward.request_uri");
		if (url != null) {
			return url.equals(requestUrl);
		}
		return request.isUserInRole(Role.ROLE_ADMIN.toString())
				|| testDescriptionService.isPublicTest(testId);
	}
}
