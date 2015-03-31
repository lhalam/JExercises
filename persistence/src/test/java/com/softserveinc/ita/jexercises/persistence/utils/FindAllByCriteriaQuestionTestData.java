package com.softserveinc.ita.jexercises.persistence.utils;

import com.softserveinc.ita.jexercises.common.dto.SearchCondition;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Taras Vuyiv
 */
@Component
public class FindAllByCriteriaQuestionTestData {
    Map<SearchCondition, Integer> dataMap;

    public Map<SearchCondition, Integer> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<SearchCondition, Integer> dataMap) {
        this.dataMap = dataMap;
    }
}
