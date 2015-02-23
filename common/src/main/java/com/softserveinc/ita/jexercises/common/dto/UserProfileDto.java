package com.softserveinc.ita.jexercises.common.dto;


import com.softserveinc.ita.jexercises.common.utils.Role;

import java.util.Date;

/**
 * Represents User Profile DTO.
 *
 * @author Taras Vuyiv
 * @version 1.0
 */
public class UserProfileDto {
    /**
     * First name of user.
     */
    private String firstName;
    /**
     * Last name of user.
     */
    private String lastName;
    /**
     * User email.
     */
    private String email;
    /**
     * User password.
     */
    private String password;
    /**
     * User registration date.
     */
    private Date registrationDate;
    /**
     * User birth date.
     */
    private Date birthDate;
    /**
     * User role.
     */
    private Role role;
    /**
     * Avatar.
     */
    private byte[] avatar;

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
