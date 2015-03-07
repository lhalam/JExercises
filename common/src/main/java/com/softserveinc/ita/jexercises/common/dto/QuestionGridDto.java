package com.softserveinc.ita.jexercises.common.dto;

/**
 * Represents QuestionGridRow DTO.
 *
 * @author Ihor Demkovych
 * @version 1.0
 */
public class QuestionGridDto {

    /**
     * Name of test.
     */
    private String name;

    /**
     * Description of test.
     */
    private String description;

    /**
     * ID of test.
     */
    private Long id;

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

}
