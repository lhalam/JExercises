package com.softserveinc.ita.jexercises.common.utils;

/**
 * Represents text formatter tool.
 *
 * @author Ihor Demkovych
 * @version 1.0
 */
public class TextFormatter {

    /**
     * To set three dots in table field.
     */
    public static final String THREEDOTS = "...";

    /**
     * Method which forms text.
     * @param string text of field.
     * @param size of field
     * @return result.
     */
    public String setThreeDots(String string, int size){
        if (string.length()>size){
            string = string.substring(0,size)+THREEDOTS;
        }
        return string;
    }
}
