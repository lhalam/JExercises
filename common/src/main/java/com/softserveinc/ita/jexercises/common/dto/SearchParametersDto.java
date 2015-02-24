package com.softserveinc.ita.jexercises.common.dto;

/**
 * Representing of Parameters DTO to Data table.
 *
 *  @author Ihor Demkovych
 * @version 1.0
 */
public class SearchParametersDto {

    /**
     * Number of elements on the page.
     */
    private int pagesize;

    /**
     * Number of page.
     */
    private int pagenumber;

    /**
     * Word used in search form.
     */
    private String searchKey;

    /**
     * Method of sorting.
     */
    private String order;

    /**
     * Number of requests.
     */
    private int draw;

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getPagenumber() {
        return pagenumber;
    }

    public void setPagenumber(int pagenumber) {
        this.pagenumber = pagenumber;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }
}
