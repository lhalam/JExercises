package com.softserveinc.ita.jexercises.business.services.impl;

import com.softserveinc.ita.jexercises.business.services.TestGridService;
import com.softserveinc.ita.jexercises.common.dto.GridResponseDto;
import com.softserveinc.ita.jexercises.common.dto.SearchCondition;
import com.softserveinc.ita.jexercises.common.dto.TestGridDto;
import com.softserveinc.ita.jexercises.common.entity.Test;
import com.softserveinc.ita.jexercises.common.mapper.TestGridMapper;
import com.softserveinc.ita.jexercises.persistence.dao.impl.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


/**
 * Represents TestGridService interface implementation.
 *
 * @author Ihor Demkovych
 * @version 1.0
 */
@Service
public class TestGridServiceImpl implements TestGridService {

    /**
     * Test DAO instance.
     */
    @Autowired
    private TestDao testDao;

    @Autowired
    private TestGridMapper testGridMapper;

    @Override
    public GridResponseDto<TestGridDto> getGridRows(SearchCondition searchCondition) {
        GridResponseDto<TestGridDto> response = new GridResponseDto<>();

        response.setDraw(searchCondition.getDraw());
        response.setRecordsFiltered(testDao.getNumberOfFilteredRecords(searchCondition));
        response.setRecordsTotal(testDao.getNumberOfRecords());

        List<Test> testList = testDao.findAllByCriteria(searchCondition);

        response.setData(testGridMapper.toDto(testList));

        return response;
    }


    @Override
    @Transactional
    public void delete(Long testId){
        testDao.deleteById(testId);
    }

}
