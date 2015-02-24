package com.softserveinc.ita.jexercises.business.services.impl;

import com.softserveinc.ita.jexercises.business.services.TestDescriptionService;
import com.softserveinc.ita.jexercises.common.dto.TestDescriptionDto;
import com.softserveinc.ita.jexercises.common.entity.Test;
import com.softserveinc.ita.jexercises.common.mapper.TestMapper;
import com.softserveinc.ita.jexercises.persistence.dao.impl.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Represents TestDescriptionService interface implementation.
 *
 * @author Volodymyr Yakymiv
 * @version 1.0
 */
@Service
public class TestDescriptionServiceImpl implements TestDescriptionService {

    /**
     * Test DAO instance.
     */
    @Autowired
    private TestDao testDao;

    @Override
    public TestDescriptionDto getTestDescription(Long id) {
        TestMapper testMapper = new TestMapper();
        Test test = testDao.findById(id);
        return testMapper.toDto(test);
    }

}
