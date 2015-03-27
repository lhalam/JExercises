package com.softserveinc.ita.jexercises.common.dto;

import com.softserveinc.ita.jexercises.common.utils.ManyToManyFilter;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents class used for findAllByCriteria method (pagination).
 *
 * @author Taras Vuyiv
 */
public class SearchCondition {

    private int draw;
    private int pageNumber;
    private int pageSize;
    private Map<String, String> orderByMap = new HashMap<>();
    private Map<String, Object> andFilterMap = new HashMap<>();
    private Map<String, Object> orFilterMap = new HashMap<>();
    private Map<String, Object> notFilterMap = new HashMap<>();
    private Map<String, Class> notInFieldMap = new HashMap<>();
    private ManyToManyFilter manyToManyAndFilter;
    private ManyToManyFilter manyToManyNotInFilter;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Map<String, String> getOrderByMap() {
        return orderByMap;
    }

    public void setOrderByMap(Map<String, String> orderByMap) {
        this.orderByMap = orderByMap;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public Map<String, Object> getAndFilterMap() {
        return andFilterMap;
    }

    public void setAndFilterMap(Map<String, Object> andFilterMap) {
        this.andFilterMap = andFilterMap;
    }

    public Map<String, Object> getOrFilterMap() {
        return orFilterMap;
    }

    public void setOrFilterMap(Map<String, Object> orFilterMap) {
        this.orFilterMap = orFilterMap;
    }

    public Map<String, Object> getNotFilterMap() {
        return notFilterMap;
    }

    public void setNotFilterMap(Map<String, Object> notFilterMap) {
        this.notFilterMap = notFilterMap;
    }

    public Map<String, Class> getNotInFieldMap() {
        return notInFieldMap;
    }

    public void setNotInFieldMap(Map<String, Class> notInFieldMap) {
        this.notInFieldMap = notInFieldMap;
    }

    public ManyToManyFilter getManyToManyAndFilter() {
        return manyToManyAndFilter;
    }

    public void setManyToManyAndFilter(ManyToManyFilter manyToManyAndFilter) {
        this.manyToManyAndFilter = manyToManyAndFilter;
    }

    public ManyToManyFilter getManyToManyNotInFilter() {
        return manyToManyNotInFilter;
    }

    public void setManyToManyNotInFilter(ManyToManyFilter manyToManyNotInFilter) {
        this.manyToManyNotInFilter = manyToManyNotInFilter;
    }
}
