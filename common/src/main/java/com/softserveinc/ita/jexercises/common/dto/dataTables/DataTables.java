package com.softserveinc.ita.jexercises.common.dto.dataTables;

import java.util.List;

/**
 * Class represents question creating DTO.
 *
 * @author Ihor Demkovych
 *
 * @version 1.0
 */
public class DataTables {

    /**
     * Number of post.
     */
    private int draw;

    /**
     * Sort and search condition to every column.
     */
    private List<Columns> columns;

    /**
     * Sort conditions.
     */
    private List<Order> order;

    /**
     * Number of the first row.
     */
    private int start;

    /**
     * Number of rows in the table.
     */
    private int length;

    /**
     * Search key.
     */
    private Search search;

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public List<Columns> getColumns() {
        return columns;
    }

    public void setColumns(List<Columns> columns) {
        this.columns = columns;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }
}
