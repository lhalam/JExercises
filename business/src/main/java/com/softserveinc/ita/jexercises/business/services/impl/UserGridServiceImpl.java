package com.softserveinc.ita.jexercises.business.services.impl;

import com.softserveinc.ita.jexercises.business.services.CurrentUserService;
import com.softserveinc.ita.jexercises.business.services.UserGridService;
import com.softserveinc.ita.jexercises.business.services.UserProfileService;
import com.softserveinc.ita.jexercises.common.dto.AttemptDto;
import com.softserveinc.ita.jexercises.common.dto.GridResponseDto;
import com.softserveinc.ita.jexercises.common.dto.SearchCondition;
import com.softserveinc.ita.jexercises.common.dto.UserProfileDto;
import com.softserveinc.ita.jexercises.common.dto.dataTables.DataTables;
import com.softserveinc.ita.jexercises.common.entity.Attempt;
import com.softserveinc.ita.jexercises.common.entity.User;
import com.softserveinc.ita.jexercises.common.mapper.AttemptMapper;
import com.softserveinc.ita.jexercises.common.mapper.DataTablesMapper;
import com.softserveinc.ita.jexercises.persistence.dao.impl.AttemptDao;
import com.softserveinc.ita.jexercises.persistence.dao.impl.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents UserGridService interface implementation.
 *
 * @author Taras Vuyiv
 */
@Service
public class UserGridServiceImpl implements UserGridService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private AttemptDao attemptDao;

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private AttemptMapper attemptMapper;

    @Autowired
    private DataTablesMapper dataTablesMapper;

    @Override
    public GridResponseDto<UserProfileDto> getUsers(
            DataTables dataTables) {
        GridResponseDto<UserProfileDto> response = new GridResponseDto<>();
        dataTables.getColumns().get(4).setData("createdDate");
        SearchCondition searchCondition =
                dataTablesMapper.toSearchCondition(dataTables);

        response.setDraw(dataTables.getDraw());
        response.setRecordsFiltered(
                userDao.getNumberOfFilteredRecords(searchCondition));
        response.setRecordsTotal(userDao.getNumberOfRecords());

        List<User> userList = userDao.findAllByCriteria(searchCondition);
        List<UserProfileDto> userProfileDtoList = new ArrayList<>();

        for (User user : userList) {
            userProfileDtoList.add(userProfileService.getUserInfo(user));
        }

        response.setData(userProfileDtoList);

        return response;
    }

    @Override
    @Transactional
    public GridResponseDto<AttemptDto> getCurrentUserAttempts(
            DataTables dataTables) {

        GridResponseDto<AttemptDto> response = new GridResponseDto<>();
        List<AttemptDto> attemptDtoList = new ArrayList<>();
        List<String> lazyFields = new ArrayList<>();

        dataTables.getColumns().get(0).setData("test.name");

        SearchCondition searchCondition =
                dataTablesMapper.toSearchCondition(dataTables);
        Long currentUserId = currentUserService.getCurrentUser().getId();

        searchCondition.getFilterByIdMap().put("user.id", currentUserId);

        List<Attempt> attemptsList = attemptDao
                .findAllByCriteria(searchCondition);

        lazyFields.add("test");
        lazyFields.add("userAnswers");

        for (Attempt attempt : attemptsList) {
            attempt = attemptDao.getLazyFields(attempt, lazyFields);
            attemptDtoList.add(attemptMapper.toAttemptDto(attempt));
        }

        response.setDraw(dataTables.getDraw());
        response.setRecordsFiltered(
                attemptDao.getNumberOfFilteredRecords(searchCondition));
        response.setRecordsTotal(attemptDao
                .getNumberOfFilteredByIdRecords(searchCondition));
        response.setData(attemptDtoList);

        return response;
    }
}
