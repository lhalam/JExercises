package com.softserveinc.ita.jexercises.common.dto;

/**
 * Represents TestGridRow DTO.
 *
 * @author Ihor Demkovych
 * @version 1.0
 */
public class SearchGridRowDto {

    /**
     * Description of test.
     */
    private String description;

    /**
     * Availability of test.
     */
    private String isPublic;

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

    public String getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(String isPublic) {
        this.isPublic = isPublic;
    }

}
