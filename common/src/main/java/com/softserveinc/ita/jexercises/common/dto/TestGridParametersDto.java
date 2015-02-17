package com.softserveinc.ita.jexercises.common.dto;

/**
 * Represents TestGridParameters DTO.
 *
 * @author Ihor Demkovych
 * @version 1.0
 */
public class TestGridParametersDto {

    /**
     * Number of page in test data table.
     */
    private int pageNumber;

    /**
     * Size of page in test data table.
     */
    private int pageSize;

    /**
     * Number of elements in test data table.
     */
    private int allElementsNumber;

    /**
     * Word in search field to obtained necessary test data table.
     */
    private String searchKey;

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

    public int getAllElementsNumber() {
        return allElementsNumber;
    }

    public void setAllElementsNumber(int allElementsNumber) {
        this.allElementsNumber = allElementsNumber;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

}