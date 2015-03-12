package com.softserveinc.ita.jexercises.business.services;

import com.softserveinc.ita.jexercises.common.dto.AttemptDto;
import com.softserveinc.ita.jexercises.common.dto.GridResponseDto;
import com.softserveinc.ita.jexercises.common.dto.UserProfileDto;
import com.softserveinc.ita.jexercises.common.dto.dataTables.DataTables;

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
     * @param dataTables Filter parameters.
     * @return Grid Response DTO with users profile info.
     */
    GridResponseDto<UserProfileDto> getUsers(
            DataTables dataTables);

    /**
     * Getting data for grid of attempts.
     *
     * @param userId User ID.
     * @param dataTables Filter parameters.
     * @return Grid Response DTO with attempts info.
     */
    GridResponseDto<AttemptDto> getUserAttempts(Long userId,
            DataTables dataTables);
}
