package com.softserveinc.ita.jexercises.business.services.impl;

import com.softserveinc.ita.jexercises.business.services.TestGridService;
import com.softserveinc.ita.jexercises.common.dto.SearchCondition;
import com.softserveinc.ita.jexercises.common.dto.TestGridDto;
import com.softserveinc.ita.jexercises.common.dto.TestGridParametersDto;
import com.softserveinc.ita.jexercises.common.dto.TestGridRowDto;
import com.softserveinc.ita.jexercises.common.entity.Test;
import com.softserveinc.ita.jexercises.persistence.dao.impl.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    /**
     * Constant symbol.
     */
    private String proword = "%";

    @Override
    public TestGridDto buildTestGrid(TestGridParametersDto
                                                 testGridParametersDto) {

        TestGridDto testGridDto = new TestGridDto();
        SearchCondition searchCondition = new SearchCondition();

        searchCondition.setPageNumber(testGridParametersDto.getPageNumber());
        searchCondition.setPageSize(testGridParametersDto.getPageSize());

        Map<String, String> filter = new LinkedHashMap<String, String>();
        Map<String, String> order = new LinkedHashMap<String, String>();

        filter.put("description", proword +
                testGridParametersDto.getSearchKey() + proword);
        order.put("id", "asc"); //desc - по спаданню

        searchCondition.setFilterMap(filter);
        searchCondition.setOrderByMap(order);

        List<TestGridRowDto> testgridrows = new ArrayList<TestGridRowDto>();
        List<Test> tests = testDao.findAllByCriteria(searchCondition);
        testGridDto.setPageNumber(1);
        testGridDto.setPageSize(1);
        testGridDto.setSearchKey("");
        testGridDto.setPagesNumber(1);
        testGridDto.setElementsNumber(1);

        for (Test test : tests) {
            TestGridRowDto testGridRowDto = new TestGridRowDto();
            testGridRowDto.setDescription(test.getDescription());
            testGridRowDto.setIsPublic(test.getIsPublic());
            testgridrows.add(testGridRowDto);
        }

        testGridDto.setTestRows(testgridrows);

        return testGridDto;
    }

    @Override
    public TestGridDto buildAllTestGrid() {
        TestGridDto testGridDto = new TestGridDto();
        List<TestGridRowDto> testgridrows = new ArrayList<TestGridRowDto>();
        List<Test> tests = testDao.findAll();
        testGridDto.setPageNumber(1);
        testGridDto.setPageSize(1);
        testGridDto.setSearchKey("");
        testGridDto.setPagesNumber(1);
        testGridDto.setElementsNumber(1);

        for (Test test : tests) {
            TestGridRowDto testGridRowDto = new TestGridRowDto();
            testGridRowDto.setDescription(test.getDescription());
            testGridRowDto.setIsPublic(test.getIsPublic());
            testgridrows.add(testGridRowDto);
        }

        testGridDto.setTestRows(testgridrows);

        return testGridDto;
    }
}
