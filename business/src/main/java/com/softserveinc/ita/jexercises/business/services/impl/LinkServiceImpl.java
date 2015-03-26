package com.softserveinc.ita.jexercises.business.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserveinc.ita.jexercises.business.services.LinkService;
import com.softserveinc.ita.jexercises.business.utils.ShortCodeUtil;
import com.softserveinc.ita.jexercises.common.dto.LinkDto;
import com.softserveinc.ita.jexercises.common.entity.Link;
import com.softserveinc.ita.jexercises.common.entity.Test;
import com.softserveinc.ita.jexercises.persistence.dao.impl.LinkDao;
import com.softserveinc.ita.jexercises.persistence.dao.impl.TestDao;

/**
 * Represents LinkService interface implementation.
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
    public void saveLink(LinkDto linkDto) {
        Test test = testDao.findById(linkDto.getTestId());
        Link link = test.getLink();
        if (link == null) {
            link = new Link();
            link.setTest(test);
        }
        link.setShortCode(linkDto.getShortCode());
        test.setLink(link);
        testDao.update(test);
    }

    @Override
    public String generateUniqueShortCode() {
        String shortCode = null;
        do {
            shortCode = shortCodeUtil.generateShortCode();
        } while (isNotUnique(shortCode));
        return shortCode;
    }

    private boolean isNotUnique(String shortCode) {
        return linkDao.findByShortCode(shortCode) != null;
    }

    @Override
    public Long findTestByLink(String shortCode) {
        Link link = linkDao.findByShortCode(shortCode);
        if (link != null) {
            return link.getTest().getId();
        }
        return null;
    }

    @Transactional
    @Override
    public void deleteLink(Long testId) {
        Test test = testDao.findById(testId);
        Link link = test.getLink();
        if (link != null) {
            linkDao.delete(link);
            test.setLink(null);
            testDao.update(test);
        }
    }

}
