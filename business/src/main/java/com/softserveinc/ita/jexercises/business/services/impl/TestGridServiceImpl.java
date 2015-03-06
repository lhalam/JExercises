package com.softserveinc.ita.jexercises.business.services.impl;

import com.softserveinc.ita.jexercises.business.services.TestGridService;
import com.softserveinc.ita.jexercises.common.dto.SearchCondition;
import com.softserveinc.ita.jexercises.common.dto.SearchGridDto;
import com.softserveinc.ita.jexercises.common.dto.dataTables.DataTablesDto;
import com.softserveinc.ita.jexercises.common.dto.dataTables.OrderDto;
import com.softserveinc.ita.jexercises.common.dto.dataTables.SearchDto;
import com.softserveinc.ita.jexercises.common.entity.Test;
import com.softserveinc.ita.jexercises.common.mapper.TestGridMapper;
import com.softserveinc.ita.jexercises.persistence.dao.impl.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public SearchGridDto buildTestGrid(DataTablesDto dataTablesDto) {

        SearchGridDto searchGridDto = new SearchGridDto();
        SearchCondition searchCondition = new SearchCondition();

        searchCondition.setPageNumber(
                Math.round( dataTablesDto.getStart()
                / dataTablesDto.getLength() ) );
        searchCondition.setPageSize(
                dataTablesDto.getLength());

        Map<String, String> filter = new LinkedHashMap<String, String>();
        Map<String, String> order = new LinkedHashMap<String, String>();

        SearchDto search = dataTablesDto.getSearch();
        filter.put("name", search.getValue());
        List<OrderDto> orders = dataTablesDto.getOrder();
        order.put("name", orders.get(0).getDir());

        searchCondition.setFilterMap(filter);
        searchCondition.setOrderByMap(order);

        List<Test> tests = testDao.findAllByCriteria(searchCondition);
        searchGridDto.setRecordsTotal(testDao.findAll().size());
        searchGridDto.setDraw( (dataTablesDto.getDraw() + 1) );
        searchGridDto.setRecordsFiltered(
            testDao.getNumberOfFilteredRecords(searchCondition));

        TestGridMapper testGridMapper = new TestGridMapper();
        searchGridDto.setTestRows(testGridMapper.toDto(tests));
        return searchGridDto;
    }

    @Override
    @Transactional
    public void delete(Long testId){
        testDao.deleteById(testId);
    }

}
