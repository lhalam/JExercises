package com.softserveinc.ita.jexercises.common.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="QUESTION")
public class Question extends BaseEntity {


@Id
@GeneratedValue
@Column (name="QUESTION_ID")
    private Long id;
@Column (name="DESCRIPTION")
    private String description;

    private Set<Test> tsetsSet = new HashSet<Test>();

    private Set<SharedAnswer> sharedAnswersSet = new HashSet<SharedAnswer>();

    private Set<Assert> assertSet = new HashSet<Asset>();

    private Set<UserAnswer> userAnswersSet = new HashSet<UserAnswer>();

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Question() {}

    public Question(Long id, String description){
        this.id=id;
        this.description=description;
    }
}
