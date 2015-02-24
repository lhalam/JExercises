package com.softserveinc.ita.jexercises.common.dto;

import java.util.List;

/**
 * Represents TestGrid DTO.
 *
 * @author Ihor Demkovych
 * @version 1.0
 */
public class SearchGridDto {

    /**
     * Number of page in test data table.
     */
    private int draw;

    /**
     * Size of page in test data table.
     */
    private int recordsTotal;

    /**
     * Number of pages in test data table.
     */
    private int recordsFiltered;

    /**
     * List of rows from data table.
     */
    private List<SearchGridRowDto> testGridRows;

    public int getDraw() { return draw; }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<SearchGridRowDto> getTestGridRows() {
        return testGridRows;
    }

    public void setTestRows(List<SearchGridRowDto> testGridRows) {
        this.testGridRows = testGridRows;
    }

}
