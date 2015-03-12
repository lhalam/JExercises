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
    public String createShortCode(Long id) {
        Link link = new Link();
        String shortCode = shortCodeUtil.generateShortCode();
        link.setShortCode(shortCode);
        link.setTest(testDao.findById(id));
        linkDao.create(link);
        return link.getShortCode();
    }

    @Transactional
    @Override
    public String updateShortCode(Long id) {
        Link link = linkDao.findByTestId(id);
        if(link!=null){
            String shortCode = shortCodeUtil.generateShortCode();
            link.setShortCode(shortCode);
            link = linkDao.update(link);
            return link.getShortCode();
        }        
        return null;
    }

    @Override
    public Long findTestByShortCode(String shortCode) {
        Link link = linkDao.findByShortCode(shortCode);
        Long testId = link.getTest().getId();
        return testId;
    }

}
