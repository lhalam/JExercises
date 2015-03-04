package com.softserveinc.ita.jexercises.common.utils;

import java.text.DateFormatSymbols;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Represents date creation helper tool.
 * 
 * @author Oksana Senchuk
 * @version 1.0
 */
public final class DateUtils {
    /**
     * Days collection.
     */
    private static final Set<Byte> DAYS = initializeDays();
    /**
     * Months collection.
     */
    private static final Map<Byte, String> MONTHS = initializeMonths();
    /**
     * Years collection.
     */
    private static final Set<Short> YEARS = initializeYears();

    /**
     * Prevents from external construction of DateUtils object.
     */
    private DateUtils() {

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

    private static Map<Byte, String> initializeMonths() {
        LinkedHashMap<Byte, String> months = new LinkedHashMap<Byte, String>();
        String[] monthsArray = new DateFormatSymbols(Locale.ENGLISH)
                .getShortMonths();
        byte maxMonth = 12;
        for (byte i = 0; i < maxMonth; i++) {
            months.put(i, monthsArray[i]);
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
