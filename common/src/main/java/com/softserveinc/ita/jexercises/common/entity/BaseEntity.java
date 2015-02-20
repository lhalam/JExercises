package com.softserveinc.ita.jexercises.common.entity;

import com.softserveinc.ita.jexercises.common.utils.AuditEntityListener;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.Version;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Represents Base Entity - parent of all entities. Contains common fields.
 *
 * @author Taras Vuyiv
 *
 */
@MappedSuperclass
@EntityListeners(AuditEntityListener.class)
public abstract class BaseEntity {

    /**
     * ID key of entity.
     */
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;
    /**
     * Email of user that created a record in database.
     */
    @Column(name = "CREATED_BY_USER")
    private String createdByUser;
    /**
     * Email of user that modified a record in database.
     */

    @Column(name = "MODIFIED_BY_USER")
    private String modifiedByUser;
    /**
     * Date a record in database has been created.
     */

    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    /**
     * Date a record in database has been modified.
     */
    @Column(name = "MODIFIED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
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

    public String getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(String createdByUser) {
        this.createdByUser = createdByUser;
    }

    public String getModifiedByUser() {
        return modifiedByUser;
    }

    public void setModifiedByUser(String modifiedByUser) {
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
