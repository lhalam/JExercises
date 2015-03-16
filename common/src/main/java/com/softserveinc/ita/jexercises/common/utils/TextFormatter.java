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
     *
     * @param strInput text of field.
     * @param size     of field
     * @return result.
     */
    public String setThreeDots(String strInput, int size) {
        String strOutput = new String();
        int count = 0;
        boolean htmlLabel = false;
        for (int i = 0; i < strInput.length(); i++) {
            if (strInput.charAt(i) == '<') {
                htmlLabel = true;
            }
            if (htmlLabel) {
                strOutput += strInput.charAt(i);
            } else {
                count++;
                if (count < size) {
                    strOutput += strInput.charAt(i);
                }
            }
            if (strInput.charAt(i) == '>') {
                htmlLabel = false;
            }
        }
        if (count > size) {
            strOutput += THREEDOTS;
        }
        return strOutput;
    }
}
