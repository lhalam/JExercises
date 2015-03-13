package com.softserveinc.ita.jexercises.business.services;

import com.softserveinc.ita.jexercises.common.dto.GridResponseDto;
import com.softserveinc.ita.jexercises.common.dto.SearchCondition;
import com.softserveinc.ita.jexercises.common.dto.UserProfileDto;

/**
 * Services used for users DataTable.
 *
 * @author Taras Vuyiv
 * @version 1.0
 */
public interface UserGridService {
    /**
     * Getting data for users grid.
     *
     * @param searchCondition Filter parameters.
     * @return Grid Response DTO with users profile info.
     */
    GridResponseDto<UserProfileDto> getUsers(
            SearchCondition searchCondition);
}
