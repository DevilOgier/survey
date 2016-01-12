/*
 * @(#)Survey.java 2014-1-10 ����09:46:15 Survey
 */
package com.survey.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * Survey
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class Survey {
    private Integer id;

    private String title;

    private String description;

    private List<Question> questionList;

    private Date date;

    private List<User> answeredUser;

    /**
     * ����  id
     * @return id
     */
    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    /**
     * ���� id
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * ����  title
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * ���� title
     * @param title title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * ����  description
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * ���� description
     * @param description description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * ����  questionList
     * @return questionList
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "survey")
    public List<Question> getQuestionList() {
        return questionList;
    }

    /**
     * ���� questionList
     * @param questionList questionList
     */
    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    /**
     * ����  date
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * ���� date
     * @param date date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * ����  answeredUser
     * @return answeredUser
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "survey_user", joinColumns = @JoinColumn(name = "survey_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    public List<User> getAnsweredUser() {
        return answeredUser;
    }

    /**
     * ���� answeredUser
     * @param answeredUser answeredUser
     */
    public void setAnsweredUser(List<User> answeredUser) {
        this.answeredUser = answeredUser;
    }
}
