package com.softserveinc.ita.jexercises.common.dto;

import com.softserveinc.ita.jexercises.common.utils.Button;

import java.util.List;

/**
 * Data Transfer Object used to return data to DataTables.
 *
 * @param <T> Class of data to be returned.
 * @author Taras Vuyiv.
 */
public class GridResponseDto<T> {
    private int draw;
    private Long recordsTotal;
    private Long recordsFiltered;
    private List<T> data;
    private List<Button> buttons;

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public Long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }
}
