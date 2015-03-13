package com.softserveinc.ita.jexercises.business.services.impl;

import com.softserveinc.ita.jexercises.business.services.AttemptGridService;
import com.softserveinc.ita.jexercises.business.services.CurrentUserService;
import com.softserveinc.ita.jexercises.common.dto.AttemptDto;
import com.softserveinc.ita.jexercises.common.dto.GridResponseDto;
import com.softserveinc.ita.jexercises.common.dto.SearchCondition;
import com.softserveinc.ita.jexercises.common.entity.Attempt;
import com.softserveinc.ita.jexercises.common.mapper.AttemptMapper;
import com.softserveinc.ita.jexercises.common.utils.Role;
import com.softserveinc.ita.jexercises.common.utils.Wrapper;
import com.softserveinc.ita.jexercises.persistence.dao.impl.AttemptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * Implementation of AttemptGridService.
 *
 * @author Taras Vuyiv
 */
@Service
public class AttemptGridServiceImpl implements AttemptGridService {

    @Autowired
    private CurrentUserService currentUserService;

    @Autowired
    private AttemptDao attemptDao;

    @Autowired
    private AttemptMapper attemptMapper;

    @Override
    @Transactional
    public GridResponseDto<AttemptDto> getUserAttempts(
            Long userId, Long testId, SearchCondition searchCondition) {

        GridResponseDto<AttemptDto> response = new GridResponseDto<>();
        List<AttemptDto> attemptDtoList = new ArrayList<>();
        List<String> lazyFields = new ArrayList<>();

        if(testId != null) {
            searchCondition.getAndFilterMap().put("test.id",
                    new Wrapper(testId));
        }

        if(userId != null) {
            searchCondition.getAndFilterMap().put("user.id",
                    new Wrapper(userId));
        }
        if (currentUserService.getCurrentUser().getRole() == Role.ROLE_USER) {
            searchCondition.getNotFilterMap().put("test.isPublic",
                    new Wrapper(false));
        }

        List<Attempt> attemptsList = attemptDao
                .findAllByCriteria(searchCondition);

        lazyFields.add("test");
        lazyFields.add("user");
        lazyFields.add("userAnswers");

        for (Attempt attempt : attemptsList) {
            attempt = attemptDao.getLazyFields(attempt, lazyFields);
            attemptDtoList.add(attemptMapper.toAttemptDto(attempt));
        }

        response.setDraw(searchCondition.getDraw());
        response.setRecordsFiltered(
                attemptDao.getNumberOfFilteredRecords(searchCondition));
        response.setRecordsTotal(attemptDao
                .getNumberOfRecords(searchCondition));
        response.setData(attemptDtoList);

        return response;
    }
}
