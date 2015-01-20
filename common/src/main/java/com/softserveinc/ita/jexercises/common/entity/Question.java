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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "question_test",  joinColumns = {
            @JoinColumn(name = "QUESTION_ID", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "TEST_ID",
                    nullable = false, updatable = false) })
    private Set<Test> tests = new HashSet<Test>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
    private Set<SharedAnswer> sharedAnswers = new HashSet<SharedAnswer>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
    private Set<Assert> asserts = new HashSet<Asset>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
    private Set<UserAnswer> userAnswers = new HashSet<UserAnswer>();




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
