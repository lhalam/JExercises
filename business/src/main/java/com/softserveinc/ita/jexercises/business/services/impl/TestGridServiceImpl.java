package com.softserveinc.ita.jexercises.business.services.impl;

import com.softserveinc.ita.jexercises.business.services.CurrentUserService;
import com.softserveinc.ita.jexercises.business.services.TestGridService;
import com.softserveinc.ita.jexercises.common.dto.GridResponseDto;
import com.softserveinc.ita.jexercises.common.dto.SearchCondition;
import com.softserveinc.ita.jexercises.common.dto.TestGridDto;
import com.softserveinc.ita.jexercises.common.entity.Test;
import com.softserveinc.ita.jexercises.common.mapper.TestGridMapper;
import com.softserveinc.ita.jexercises.common.utils.Button;
import com.softserveinc.ita.jexercises.common.utils.Role;
import com.softserveinc.ita.jexercises.common.utils.Wrapper;
import com.softserveinc.ita.jexercises.persistence.dao.impl.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    /**
     * TestGridMapper instance.
     */
    @Autowired
    private TestGridMapper testGridMapper;
    /**
    * CurrentUserService instance.
    */
    @Autowired
    private CurrentUserService currentUserService;

    @Override
    public GridResponseDto<TestGridDto> getGridRows(SearchCondition searchCondition) {
        GridResponseDto<TestGridDto> response = new GridResponseDto<>();
        if (currentUserService.getCurrentUser().getRole() == Role.ROLE_USER) {
            searchCondition.getNotFilterMap().put("isPublic",
                    new Wrapper(false));
        }
        response.setDraw(searchCondition.getDraw());
        response.setRecordsFiltered(testDao.getNumberOfFilteredRecords(searchCondition));
        response.setRecordsTotal(testDao.getNumberOfRecords(searchCondition));
        List<Test> testList = testDao.findAllByCriteria(searchCondition);
        response.setData(testGridMapper.toDto(testList));
        List<Button> buttons = new ArrayList<>();
        if (currentUserService.getCurrentUser().getRole() == Role.ROLE_ADMIN )
        {
            buttons.add(Button.START_TEST);
            buttons.add(Button.VIEW_ATTEMPTS);
            buttons.add(Button.EDIT);
            buttons.add(Button.DELETE);
        }
        if (currentUserService.getCurrentUser().getRole() == Role.ROLE_USER)
        {
            buttons.add(Button.START_TEST);
            buttons.add(Button.VIEW_MY_ATTEMPTS);
        }
        response.setButtons(buttons);
        return response;
    }


    @Override
    @Transactional
    public void delete(Long testId){
        testDao.deleteById(testId);
    }

}
