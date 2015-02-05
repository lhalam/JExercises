package com.softserveinc.ita.jexercises.common.dto;

/**
 * Represents class used for findAllByCriteria method (pagination).
 *
 * @author Taras Vuyiv
 */
public class SearchCondition {
    /**
     * Number of page.
     */
    private int pageNumber;
    /**
     * Number of values per page.
     */
    private int pageSize;
    /**
     * Field for sorting.
     */
    private String sortField;
    /**
     * Direction of sorting (asc or desc).
     */
    private String sortDirection;
    /**
     * Filter text.
     */
    private String filter;

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

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }
}
