package com.softserveinc.ita.jexercises.common.dto;

import com.softserveinc.ita.jexercises.common.utils.Wrapper;

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
    private Map<String, Wrapper> andFilterMap = new HashMap<>();
    private Map<String, Wrapper> orFilterMap = new HashMap<>();
    private Map<String, Wrapper> notFilterMap = new HashMap<>();

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

    public Map<String, Wrapper> getAndFilterMap() {
        return andFilterMap;
    }

    public void setAndFilterMap(Map<String, Wrapper> andFilterMap) {
        this.andFilterMap = andFilterMap;
    }

    public Map<String, Wrapper> getOrFilterMap() {
        return orFilterMap;
    }

    public void setOrFilterMap(Map<String, Wrapper> orFilterMap) {
        this.orFilterMap = orFilterMap;
    }

    public Map<String, Wrapper> getNotFilterMap() {
        return notFilterMap;
    }

    public void setNotFilterMap(Map<String, Wrapper> notFilterMap) {
        this.notFilterMap = notFilterMap;
    }
}
