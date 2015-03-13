package com.softserveinc.ita.jexercises.common.utils;

/**
 * Util class for field values wrapping in SearchCondition filter maps.
 *
 * @author Taras Vuyiv
 */
public class Wrapper {
    private String stringObject;
    private Long longObject;
    private Boolean booleanObject;

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
}
