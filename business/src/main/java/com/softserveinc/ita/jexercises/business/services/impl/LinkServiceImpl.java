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
    public String generateLink(String urlPart, Long testId) {
        boolean isNew = false;
        String shortCode = shortCodeUtil.generateShortCode();
        Link link = linkDao.findByTestId(testId);
        if (link == null) {
            isNew = true;
            link = new Link();
            link.setTest(testDao.findById(testId));
        }
        link.setUrl(String.format("%s/%s", urlPart, shortCode));
        if (isNew) {
            return linkDao.create(link).getUrl();
        }
        return linkDao.update(link).getUrl();
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
