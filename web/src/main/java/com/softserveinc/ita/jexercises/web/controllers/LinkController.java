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
    private static final String DOMAIN = "localhost:8080";
    private static final String PROTOCOL = "http";

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
        String shortCode = linkService.createShortCode(id);
        String link = String.format("%s://%s%s/%s", PROTOCOL, DOMAIN,
                request.getContextPath(), shortCode);
        return link;
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
    public String updatePublicLink(@PathVariable("id") Long id,
            HttpServletRequest request) {
        String shortCode = linkService.updateShortCode(id);
        String link = String.format("%s://%s%s/%s", PROTOCOL, DOMAIN,
                request.getContextPath(), shortCode);
        return link;
    }

    /**
     * Forwards to page of testing.
     * 
     * @param shortCode
     *            Shortened url.
     * @return Page of testing.
     */
    @RequestMapping(value = "/{shortCode}", method = { RequestMethod.GET,
            RequestMethod.POST })
    public String showPrivateTest(@PathVariable("shortCode") String shortCode) {
        Long testId = linkService.findTestByShortCode(shortCode);
        String url = String.format("forward:/test/process/%d", testId);
        return url;
    }

}
