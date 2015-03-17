package com.softserveinc.ita.jexercises.business.services.impl;

import com.softserveinc.ita.jexercises.business.services.AttemptGridService;
import com.softserveinc.ita.jexercises.common.dto.AttemptDto;
import com.softserveinc.ita.jexercises.common.dto.GridResponseDto;
import com.softserveinc.ita.jexercises.common.dto.SearchCondition;
import com.softserveinc.ita.jexercises.common.entity.Attempt;
import com.softserveinc.ita.jexercises.common.mapper.AttemptMapper;
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
    private AttemptDao attemptDao;

    @Autowired
    private AttemptMapper attemptMapper;

    @Override
    @Transactional
    public GridResponseDto<AttemptDto> getUserAttempts(
            SearchCondition searchCondition) {

        GridResponseDto<AttemptDto> response = new GridResponseDto<>();
        List<AttemptDto> attemptDtoList = new ArrayList<>();

        List<Attempt> attemptsList = attemptDao
                .findAllByCriteria(searchCondition);

        for (Attempt attempt : attemptsList) {
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
