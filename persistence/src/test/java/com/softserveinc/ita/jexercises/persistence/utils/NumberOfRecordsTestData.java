package com.softserveinc.ita.jexercises.persistence.utils;

import com.softserveinc.ita.jexercises.common.dto.SearchCondition;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Taras Vuyiv
 */
@Component
public class NumberOfRecordsTestData {
    Map<SearchCondition, Long> dataMap;

    public Map<SearchCondition, Long> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<SearchCondition, Long> dataMap) {
        this.dataMap = dataMap;
    }
}
