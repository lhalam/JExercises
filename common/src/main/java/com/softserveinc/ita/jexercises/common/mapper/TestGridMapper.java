package com.softserveinc.ita.jexercises.common.mapper;

import com.softserveinc.ita.jexercises.common.dto.SearchGridRowDto;
import com.softserveinc.ita.jexercises.common.entity.Test;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents entity/DTO mapping tool.
 *
 * @author Ihor Demkovych
 * @version 1.0
 */
@Component
public class TestGridMapper {
    /**
     * Transforms Test entity object into TestDescription DTO object.
     *
     * @param tests list of Test entity.
     * @return List SearchGridRows DTO.
     */
    public List<SearchGridRowDto> toDto(List<Test> tests) {
        List<SearchGridRowDto> searchGridRows = new ArrayList<SearchGridRowDto>();
        for (Test test : tests) {
            SearchGridRowDto searchGridRowDto = new SearchGridRowDto();
            searchGridRowDto.setDescription(test.getName());
            if (test.getIsPublic()) {
                searchGridRowDto.setIsPublic("Public");
            } else {
                searchGridRowDto.setIsPublic("Private");
            }
            searchGridRowDto.setId(test.getId());
            searchGridRows.add(searchGridRowDto);
        }
        return searchGridRows;
    }
}
