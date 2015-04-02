package com.softserveinc.ita.jexercises.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softserveinc.ita.jexercises.business.services.LinkService;
import com.softserveinc.ita.jexercises.business.services.TestProcessService;
import com.softserveinc.ita.jexercises.common.dto.LinkDto;
import com.softserveinc.ita.jexercises.web.utils.ResourceNotFoundException;

/**
 * Controls public link manipulation.
 * 
 * @author Oksana Senchuk
 * @version 1.0
 */
@Controller
public class LinkController {

    @Autowired
    private LinkService linkService;

    @Autowired
    private TestProcessService testProcessService;

    /**
     * Gets new or updated public link short code.
     * 
     * @param request
     *            HttpServletRequest.
     * @return New or updated public link short code.
     */
    @RequestMapping(value = "/public/link/generate", method = RequestMethod.POST)
    @ResponseBody
    public String generateLink(HttpServletRequest request) {
        return linkService.generateUniqueShortCode();
    }

    /**
     * Saves public link.
     * 
     * @param linkDto
     *            LinkDto object.
     */
    @RequestMapping(value = "/public/link/save", method = RequestMethod.POST)
    public void savePublicLink(@RequestBody LinkDto linkDto) {
        linkService.saveLink(linkDto);
    }

    /**
     * Deletes public link.
     * 
     * @param id
     *            Test id.
     */
    @RequestMapping(value = "/public/link/delete/{id}", method = RequestMethod.DELETE)
    public void deletePublicLink(@PathVariable Long id) {
        linkService.deleteLink(id);
    }

    /**
     * Forwards to test description page.
     *
     * @param shortCode
     *            Url short code.
     * @param request
     *            HttpServletRequest.
     * @return Test description page.
     */
    @RequestMapping(value = "/{shortCode}", method = { RequestMethod.GET,
            RequestMethod.POST })
    public String showPrivateTest(@PathVariable("shortCode") String shortCode,
            HttpServletRequest request){
        Long testId = linkService.findTestByLink(shortCode);
        if (testId == null) {
            throw new ResourceNotFoundException();
        }
        request.setAttribute("publicLink",
        	   String.format("%s/%s", request.getContextPath(),shortCode));
        return String.format("forward:/test/%d", testId);
    }

}
