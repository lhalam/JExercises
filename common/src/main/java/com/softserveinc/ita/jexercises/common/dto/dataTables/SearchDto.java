package com.softserveinc.ita.jexercises.common.dto.dataTables;


/**
 * Class which describes search conditions.
 *
 * @author Ihor Demkovych.
 *
 * @version 1.0
 */
public class SearchDto{

    /**
     * Filtering word.
     */
    public String value;

    /**
     * Value which shows if is searching present.
     */
    public boolean regex;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isRegex() {
        return regex;
    }

    public void setRegex(boolean regex) {
        this.regex = regex;
    }
}

