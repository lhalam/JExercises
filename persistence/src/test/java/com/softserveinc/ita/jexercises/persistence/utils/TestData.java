package com.softserveinc.ita.jexercises.persistence.utils;

import com.softserveinc.ita.jexercises.common.dto.SearchCondition;

import java.util.Map;

/**
 * @author Taras Vuyiv
 */
public abstract class TestData {
    private Map<SearchCondition, Integer> dataMap;

    public Map<SearchCondition, Integer> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<SearchCondition, Integer> dataMap) {
        this.dataMap = dataMap;
    }
}
