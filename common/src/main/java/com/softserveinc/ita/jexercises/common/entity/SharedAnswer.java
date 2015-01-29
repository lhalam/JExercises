package com.softserveinc.ita.jexercises.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Represents SharedAnswer Entity
 * 
 * @author Oleg Pavlish
 * @version 1.0
 */
@Entity
@Table(name = "SHARED_ANSWER")
public class SharedAnswer extends BaseEntity {

    /**
     * Comment on the question
     */
    @Column(name = "COMMENT")
    private String comment;

    /**
     * Id of parent comment node
     */
    @Column(name = "PARENT_ID")
    private Long parentId;

    /**
     * Commented question
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    /**
     * Default constructor providing new instance of sharedAnswer
     */
    public SharedAnswer() {
    }

    /**
     * Constructor providing new instance of sharedAnswer
     * 
     * @param comment
     *            Coment on question
     */
    public SharedAnswer(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
