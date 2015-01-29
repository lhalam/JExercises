package com.softserveinc.ita.jexercises.common.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.persistence.MappedSuperclass;

/**
 * Represents Base Entity - parent of all entities. Contains common fields.
 * 
 * @author Taras Vuyiv
 *
 */
@MappedSuperclass
public abstract class BaseEntity {

    /**
     * ID key of entity.
     */
    @Id
    @GeneratedValue
    @Column(name = "ID")
    @Basic(optional = false)
    private Long id;

    /**
     * ID of user that created a record in database.
     */
    @Column(name = "CREATED_BY_USER")
    private Long createdByUser;

    /**
     * ID of user that modified a record in database.
     */
    @Column(name = "MODIFIED_BY_USER")
    private Long modifiedByUser;

    /**
     * Date a record in database has been created.
     */
    @Column(name = "CREATED_DATE")
    private Date createdDate;

    /**
     * Date a record in database has been modified.
     */
    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

    /**
     * Version of the record.
     */
    @Column(name = "VERSION")
    @Version
    private Long version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(Long createdByUser) {
        this.createdByUser = createdByUser;
    }

    public Long getModifiedByUser() {
        return modifiedByUser;
    }

    public void setModifiedByUser(Long modifiedByUser) {
        this.modifiedByUser = modifiedByUser;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

}
