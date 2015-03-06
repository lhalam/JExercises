package com.softserveinc.ita.jexercises.common.dto;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Represents class used for findAllByCriteria method (pagination).
 *
 * @author Taras Vuyiv
 */
public class SearchCondition {
    /**
     * Draw counter.
     */
    private int draw;
    /**
     * Number of page.
     */
    private int pageNumber;
    /**
     * Number of values per page.
     */
    private int pageSize;
    /**
     * Map for ordering. Contains sortField as key and sortDirection as value.
     */
    private Map<String, String> orderByMap = new
            LinkedHashMap<String, String>();
    /**
     * Map for filtering. Contains filterField as key and filterValue as value.
     */
    private Map<String, String> filterMap = new LinkedHashMap<String, String>();

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

    public Map<String, String> getFilterMap() {
        return filterMap;
    }

    public void setFilterMap(Map<String, String> filterMap) {
        this.filterMap = filterMap;
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
}
