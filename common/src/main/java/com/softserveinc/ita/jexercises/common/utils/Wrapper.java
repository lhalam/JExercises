package com.softserveinc.ita.jexercises.common.utils;

import java.util.List;

/**
 * Util class for field values wrapping in SearchCondition filter maps.
 *
 * @author Taras Vuyiv
 */
public class Wrapper {
    private String stringObject;
    private Long longObject;
    private Boolean booleanObject;
    private List<Long> longList;

    /**
     * String constructor.
     *
     * @param stringObject String.
     */
    public Wrapper(String stringObject) {
        this.stringObject = stringObject;
    }

    /**
     * Long constructor.
     *
     * @param longObject Long number.
     */
    public Wrapper(Long longObject) {
        this.longObject = longObject;
    }

    /**
     * Boolean constructor.
     *
     * @param booleanObject Boolean.
     */
    public Wrapper(Boolean booleanObject) {
        this.booleanObject = booleanObject;
    }

    /**
     * List of Long constructor.
     *
     * @param longList List of Long data.
     */
    public Wrapper(List<Long> longList) {
        this.longList = longList;
    }

    public String getStringObject() {
        return stringObject;
    }

    public void setStringObject(String stringObject) {
        this.stringObject = stringObject;
    }

    public Long getLongObject() {
        return longObject;
    }

    public void setLongObject(Long longObject) {
        this.longObject = longObject;
    }

    public Boolean getBooleanObject() {
        return booleanObject;
    }

    public void setBooleanObject(Boolean booleanObject) {
        this.booleanObject = booleanObject;
    }

    public List<Long> getLongList() {
        return longList;
    }

    public void setLongList(List<Long> longList) {
        this.longList = longList;
    }
}
