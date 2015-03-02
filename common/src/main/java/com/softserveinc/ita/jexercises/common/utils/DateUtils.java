package com.softserveinc.ita.jexercises.common.utils;

import java.text.DateFormatSymbols;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Represents model of date picker tool.
 * 
 * @author Oksana Senchuk
 * @version 1.0
 */
public final class DateUtils {
    /**
     * Days set.
     */
    private static final Set<Byte> DAYS = initializeDays();
    /**
     * Years set.
     */
    private static final Set<Short> YEARS = initializeYears();
    /**
     * Months map.
     */
    private static final Map<Byte, String> MONTHS = initializeMonths();

    /**
     * Constructs DatePicker object.
     */
    private DateUtils() {

    }

    private static Map<Byte, String> initializeMonths() {
        LinkedHashMap<Byte, String> months = new LinkedHashMap<Byte, String>();
        String[] monthsArray = new DateFormatSymbols(Locale.ENGLISH)
                .getShortMonths();
        byte minMonth = 1;
        byte maxMonth = 12;
        for (byte i = minMonth; i <= maxMonth; i++) {
            months.put(i, monthsArray[i - 1]);
        }
        return months;
    }

    private static Set<Short> initializeYears() {
        LinkedHashSet<Short> years = new LinkedHashSet<Short>();
        short minYear = 1905;
        short maxYear = 2015;
        for (short i = maxYear; i >= minYear; i--) {
            years.add(i);
        }
        return years;
    }

    private static Set<Byte> initializeDays() {
        TreeSet<Byte> days = new TreeSet<Byte>();
        byte minDay = 1;
        byte maxDay = 31;
        for (byte i = minDay; i <= maxDay; i++) {
            days.add(i);
        }
        return days;
    }

    public static Set<Byte> getDays() {
        return DAYS;
    }

    public static Map<Byte, String> getMonths() {
        return MONTHS;
    }

    public static Set<Short> getYears() {
        return YEARS;
    }

}
