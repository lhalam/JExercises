package com.softserveinc.ita.jexercises.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.softserveinc.ita.jexercises.business.services.LinkService;

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

    /**
     * Gets new public link.
     * 
     * @param id
     *            Test id.
     * @param request
     *            HttpServletRequest.
     * @return New public link.
     */
    @RequestMapping(value = "/public/link/create/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String generatePublicLink(@PathVariable("id") Long id,
            HttpServletRequest request) {
        String urlPart = constructUrlPart(request);
        return linkService.createLink(urlPart, id);
    }

    /**
     * Gets updated public link.
     * 
     * @param id
     *            Test id.
     * @param request
     *            HttpServletRequest.
     * @return Updated public link.
     */
    @RequestMapping(value = "/public/link/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String regeneratePublicLink(@PathVariable("id") Long id,
            HttpServletRequest request) {
        String urlPart = constructUrlPart(request);
        return linkService.updateLink(urlPart, id);
    }

    /**
     * 
     * Forwards to test description page.
     *
     * @param request
     *            HttpServletRequest.
     * @return Test description page.
     */
    @RequestMapping(value = "/{publicLinkShortCode}", method = {
            RequestMethod.GET, RequestMethod.POST })
    public String showPrivateTest(HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        Long testId = linkService.findTestByUrl(url);
        return String.format("forward:/test/%d", testId);

    }

    private String constructUrlPart(HttpServletRequest request) {
        return String.format("http://%s:%s%s", request.getServerName(),
                request.getServerPort(), request.getContextPath());
    }

}
