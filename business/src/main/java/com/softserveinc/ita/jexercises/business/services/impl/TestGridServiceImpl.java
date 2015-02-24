package com.softserveinc.ita.jexercises.business.services.impl;

import com.softserveinc.ita.jexercises.business.services.TestGridService;
import com.softserveinc.ita.jexercises.common.dto.SearchCondition;
import com.softserveinc.ita.jexercises.common.dto.SearchParametersDto;
import com.softserveinc.ita.jexercises.common.dto.SearchGridDto;
import com.softserveinc.ita.jexercises.common.dto.SearchGridRowDto;
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
    public SearchGridDto buildTestGrid(SearchParametersDto
        searchParametersDto) {

        SearchGridDto searchGridDto = new SearchGridDto();
        SearchCondition searchCondition = new SearchCondition();

        searchCondition.setPageNumber(
                Math.round(searchParametersDto.getPagenumber()
                / searchParametersDto.getPagesize()));
        searchCondition.setPageSize(
            searchParametersDto.getPagesize() );

        Map<String, String> filter = new LinkedHashMap<String, String>();
        Map<String, String> order = new LinkedHashMap<String, String>();

        filter.put("name", proword +
                searchParametersDto.getSearchKey() + proword);
        order.put("id", searchParametersDto.getOrder());

        searchCondition.setFilterMap(filter);
        searchCondition.setOrderByMap(order);

        List<SearchGridRowDto> testgridrows = new ArrayList<SearchGridRowDto>();
        List<Test> tests = testDao.findAllByCriteria(searchCondition);
        searchGridDto.setRecordsTotal(testDao.findAll().size());
        searchGridDto.setDraw( ((int)searchParametersDto.getDraw() + 1) );
        searchGridDto.setRecordsFiltered(
            testDao.getNumberOfAllResults(searchCondition));

        for (Test test : tests) {
            SearchGridRowDto searchGridRowDto = new SearchGridRowDto();
            searchGridRowDto.setDescription(test.getName());
            if (test.getIsPublic()) {
                searchGridRowDto.setIsPublic("Public");
            } else {
                searchGridRowDto.setIsPublic("Private");
            }
            searchGridRowDto.setId(test.getId());
            testgridrows.add(searchGridRowDto);
        }

        searchGridDto.setTestRows(testgridrows);
        return searchGridDto;
    }

}
