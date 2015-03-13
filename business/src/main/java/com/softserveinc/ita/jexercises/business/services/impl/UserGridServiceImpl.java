package com.softserveinc.ita.jexercises.business.services.impl;

import com.softserveinc.ita.jexercises.business.services.UserGridService;
import com.softserveinc.ita.jexercises.business.services.UserProfileService;
import com.softserveinc.ita.jexercises.common.dto.GridResponseDto;
import com.softserveinc.ita.jexercises.common.dto.SearchCondition;
import com.softserveinc.ita.jexercises.common.dto.UserProfileDto;
import com.softserveinc.ita.jexercises.common.entity.User;
import com.softserveinc.ita.jexercises.persistence.dao.impl.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private UserProfileService userProfileService;

    @Override
    public GridResponseDto<UserProfileDto> getUsers(
            SearchCondition searchCondition) {
        GridResponseDto<UserProfileDto> response = new GridResponseDto<>();

        response.setDraw(searchCondition.getDraw());
        response.setRecordsFiltered(
                userDao.getNumberOfFilteredRecords(searchCondition));
        response.setRecordsTotal(userDao.getNumberOfRecords(searchCondition));

        List<User> userList = userDao.findAllByCriteria(searchCondition);
        List<UserProfileDto> userProfileDtoList = new ArrayList<>();

        for (User user : userList) {
            userProfileDtoList.add(userProfileService.getUserInfo(user));
        }

        response.setData(userProfileDtoList);

        return response;
    }
}
