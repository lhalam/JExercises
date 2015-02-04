package com.softserveinc.ita.jexercises.common.dto;

public class SearchCondition {
    private int pageNumber;
    private int pageSize;
    private String sortField;
    private String sortDirection;
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
