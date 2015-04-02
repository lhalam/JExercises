package com.softserveinc.ita.jexercises.common.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.softserveinc.ita.jexercises.common.utils.Role;

/**
 * Represents User Entity.
 * 
 * @author Oksana Senchuk
 * @version 1.0
 */
@Entity
@Table(name = "USER")
public class User extends BaseEntity {
   
    /**
     * User first name.
     */
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    /**
     * User last name.
     */
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    /**
     * User email.
     */
    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    /**
     * User avatar picture.
     */
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "AVATAR")
    private byte[] avatar;

    /**
     * User password.
     */
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    /**
     * The set of user attempts.
     */
    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Attempt> attempts;

    /**
     * User role.
     */
    @Column(name = "ROLE", nullable = false)
    private Role role;

    /**
     * User date of birth.
     */
    @Column(name = "BIRTH_DATE", nullable = false)
    private Date birthDate;

    /**
     * Creates a new User.
     */
    public User() {

    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Attempt> getAttempts() {
        return attempts;
    }

    public void setAttempts(Set<Attempt> attempts) {
        this.attempts = attempts;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
