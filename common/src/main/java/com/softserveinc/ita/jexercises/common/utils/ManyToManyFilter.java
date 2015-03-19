package com.softserveinc.ita.jexercises.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Filter used in SearchCondition for many-to-many relationships.
 *
 * @author Taras Vuyiv
 */
public class ManyToManyFilter {
    private Class joinClass;
    private String joinFieldName;
    private Map<String, Object> filterMap = new HashMap<>();
    private String notInFieldName;
    private Class notInFieldClass;

    public Class getJoinClass() {
        return joinClass;
    }

    public void setJoinClass(Class joinClass) {
        this.joinClass = joinClass;
    }

    public String getJoinFieldName() {
        return joinFieldName;
    }

    public void setJoinFieldName(String joinFieldName) {
        this.joinFieldName = joinFieldName;
    }


    public String getNotInFieldName() {
        return notInFieldName;
    }

    public void setNotInFieldName(String notInFieldName) {
        this.notInFieldName = notInFieldName;
    }

    public Map<String, Object> getFilterMap() {
        return filterMap;
    }

    public void setFilterMap(Map<String, Object> filterMap) {
        this.filterMap = filterMap;
    }

    public Class getNotInFieldClass() {
        return notInFieldClass;
    }

    public void setNotInFieldClass(Class notInFieldClass) {
        this.notInFieldClass = notInFieldClass;
    }
}
