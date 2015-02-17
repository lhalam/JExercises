package com.softserveinc.ita.jexercises.common.dto;

/**
 * Represents TestGridRow DTO.
 *
 * @author Ihor Demkovych
 * @version 1.0
 */
public class TestGridRowDto {

    /**
     * Description of test.
     */
    private String description;

    /**
     * Availability of test.
     */
    private String isPublic;

    public String getDescription() {
        return description;
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
