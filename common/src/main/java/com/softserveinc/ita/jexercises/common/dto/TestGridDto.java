package com.softserveinc.ita.jexercises.common.dto;

/**
 * Represents TestGrid DTO.
 *
 * @author Ihor Demkovych
 * @version 1.0
 */
public class TestGridDto {

    /**
     * Description of test.
     */
    private String description;
    /**
     * Availability of test.
     */
    private Boolean isPublic;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description=description;
    }

    public Boolean getIsPublic() {
        return isPublic;

    public void setIsPublic(Boolean isPublic){
        this.isPublic=isPublic;
    }

}
