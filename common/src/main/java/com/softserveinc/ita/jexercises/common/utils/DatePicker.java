package com.softserveinc.ita.jexercises.common.utils;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
/**
 * Represents model of date picker tool.
 * @author Oksana Senchuk
 *@version 1.0
 */
public class DatePicker {
    /**
     * Datepicker's days list.
     */
    private List<Integer> days;

    /**
     * Datepicker's months list.
     */
    private HashMap<Integer, String> months;

    /**
     * Datepicker's years list.
     */
    private List<Integer> years;
    
    public List<Integer> getDays() {
        return days;
    }

    public HashMap<Integer, String> getMonths() {
        return months;
    }

    public List<Integer> getYears() {
        return years;
    }
    /**
     * Constructs DatePicker object.
     */
    public DatePicker() {
        prepareDateLists();
    }

    /**
     * Prepares lists of data for date picker.
     */
    private void prepareDateLists() {
        String[] monthsArray = new DateFormatSymbols(Locale.ENGLISH)
                .getShortMonths();
        int maxDay = 31;
        int minDay = 1;
        int minYear = 1905;
        int maxYear = 2015;
        int minMonth = 1;
        int maxMonth = 12;
        days = new ArrayList<Integer>();
        months = new LinkedHashMap<Integer, String>();
        years = new ArrayList<Integer>();
        for (int i = minDay; i <= maxDay; i++) {
            days.add(i);
        }
        for (int i = maxYear; i >= minYear; i--) {
            years.add(i);
        }
        for (int i = minMonth; i <= maxMonth; i++) {
            months.put(i, monthsArray[i - 1]);
        }
    }
}
