package com.softserveinc.ita.jexercises.web.controllers;

import javax.servlet.http.HttpServletRequest;

import com.softserveinc.ita.jexercises.business.services.TestProcessService;
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

    @Autowired
    private TestProcessService testProcessService;

    /**
     * Gets new or updated public link.
     * 
     * @param id
     *            Test id.
     * @param request
     *            HttpServletRequest.
     * @return New or updated public link.
     */
    @RequestMapping(value = "/public/link/generate/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String generatePublicLink(@PathVariable("id") Long id,
            HttpServletRequest request) {
        String url = linkService.generateLink(id);
        return constructFullUrl(request, url);
    }

    /**
     * 
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
            HttpServletRequest request) {
        Long testId = linkService.findTestByLink(shortCode);
        testProcessService.createAttemptForPrivateTest(testId);
        return String.format("forward:/test/%d", testId);

    }

    private String constructFullUrl(HttpServletRequest request, String url) {
        return String.format("http://%s:%s%s/%s", request.getServerName(),
                request.getServerPort(), request.getContextPath(), url);
    }

}
