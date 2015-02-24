package com.softserveinc.ita.jexercises.common.dto;

/**
 * Represents TestDescription DTO.
 *
 * @author Volodymyr Yakymiv
 * @version 1.0
 */
public class TestDescriptionDto {

    /**
     * Name of test.
     */
    public String name;

    /**
     * Id of test.
     */
    private Long id;

    /**
     * Description of test.
     */
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
