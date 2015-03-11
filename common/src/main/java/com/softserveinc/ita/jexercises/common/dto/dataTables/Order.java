package com.softserveinc.ita.jexercises.common.dto.dataTables;

/**
 * @author Ihor Demkovych
 *
 * @version 1.0
 * Class which describes sorting method.
 */
public class Order {

    /**
     * Number of column which will be sorted.
     */
    private int column;

    /**
     * Method of sorting.
     */
    private String dir;

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }
}
