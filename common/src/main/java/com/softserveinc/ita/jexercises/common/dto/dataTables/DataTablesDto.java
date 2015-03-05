package com.softserveinc.ita.jexercises.common.dto.dataTables;

import java.util.List;

/**
 * Class represents question creating DTO.
 *
 * @author Ihor Demkovych
 *
 * @version 1.0
 */
public class DataTablesDto {

    /**
     * Number of post.
     */
    private int draw;

    /**
     * Sort and search condition to every column.
     */
    private List<ColumnsDto> columns;

    /**
     * Sort conditions.
     */
    private List<OrderDto> order;

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
    private SearchDto search;

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public List<ColumnsDto> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnsDto> columns) {
        this.columns = columns;
    }

    public List<OrderDto> getOrder() {
        return order;
    }

    public void setOrder(List<OrderDto> order) {
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

    public SearchDto getSearch() {
        return search;
    }

    public void setSearch(SearchDto search) {
        this.search = search;
    }
}
