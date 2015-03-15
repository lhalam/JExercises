package com.softserveinc.ita.jexercises.business.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserveinc.ita.jexercises.business.services.LinkService;
import com.softserveinc.ita.jexercises.business.utils.ShortCodeUtil;
import com.softserveinc.ita.jexercises.common.entity.Link;
import com.softserveinc.ita.jexercises.persistence.dao.impl.LinkDao;
import com.softserveinc.ita.jexercises.persistence.dao.impl.TestDao;

/**
 * Represents LinkrService interface implementation.
 * 
 * @author Oksana Senchuk
 * @version 1.0
 */
@Service
public class LinkServiceImpl implements LinkService {
    @Autowired
    private LinkDao linkDao;

    @Autowired
    private TestDao testDao;

    @Autowired
    private ShortCodeUtil shortCodeUtil;

    @Transactional
    @Override
    public String createLink(String urlPart, Long testId) {
        Link link = new Link();
        addUrl(urlPart, link);
        link.setTest(testDao.findById(testId));
        return linkDao.create(link).getUrl();
    }

    @Transactional
    @Override
    public String updateLink(String urlPart, Long testId) {
        Link link = linkDao.findByTestId(testId);
        addUrl(urlPart, link);
        return linkDao.update(link).getUrl();
    }

    private void addUrl(String urlPart, Link link) {
        String shortCode = null;
        do {
            shortCode = shortCodeUtil.generateShortCode();
        } while (isNotUnique(shortCode));
        String url = String.format("%s/%s", urlPart, shortCode);
        link.setUrl(url);
    }

    private boolean isNotUnique(String shortCode) {
        return linkDao.findByShortCode(shortCode) != null;
    }

    @Override
    public Long findTestByUrl(String url) {
        Link link = linkDao.findByUrl(url);
        if (link != null) {
            return link.getTest().getId();
        }
        return null;
    }

}
