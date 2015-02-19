package com.softserveinc.ita.jexercises.common.dto;

import java.util.List;

/**
 * Represents TestGrid DTO.
 *
 * @author Ihor Demkovych
 * @version 1.0
 */
public class TestGridDto {

    /**
     * Number of page in test data table.
     */
    private int pageNumber;

    /**
     * Size of page in test data table.
     */
    private int pageSize;

    /**
     * Number of pages in test data table.
     */
    private int pagesNumber;

    /**
     * Number of elements in test data table.
     */
    private int elementsNumber;

    /**
     * Number of elements in test data table.
     */
    private String searchKey;

    /**
     * List of rows from data table.
     */
    private List<TestGridRowDto> testGridRows;

    public int getElementsNumber() {
        return elementsNumber;
    }

    public void setElementsNumber(int elementsNumber) {
        this.elementsNumber = elementsNumber;
    }

    public int getPagesNumber() {
        return pagesNumber;
    }

    public void setPagesNumber(int pagesNumber) {
        this.pagesNumber = pagesNumber;
    }

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

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public List<TestGridRowDto> getTestGridRows() {
        return testGridRows;
    }

    public void setTestRows(List<TestGridRowDto> testGridRows) {
        this.testGridRows = testGridRows;
    }
}
