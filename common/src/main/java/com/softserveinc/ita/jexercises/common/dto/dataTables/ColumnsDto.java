package com.softserveinc.ita.jexercises.common.dto.dataTables;


/**
 * Class which describes search condition of each column.
 *
 * @author Ihor Demkovych.
 *
 * @version 1.0
 */
public class ColumnsDto{

    /**
     * Name of row.
     */
    public String data;

    /**
     * Name of row.
     */
    public String name;

    /**
     * Value which shows is searching present.
     */
    public boolean searchable;

    /**
     * Value which shows is ordering present.
     */
    public boolean orderable;

    /**
     * Search conditions to each column.
     */
    public SearchDto search;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSearchable() {
        return searchable;
    }

    public void setSearchable(boolean searchable) {
        this.searchable = searchable;
    }

    public boolean isOrderable() {
        return orderable;
    }

    public void setOrderable(boolean orderable) {
        this.orderable = orderable;
    }

    public SearchDto getSearch() {
        return search;
    }

    public void setSearch(SearchDto search) {
        this.search = search;
    }
}

