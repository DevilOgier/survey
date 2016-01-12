/*
 * @(#)HomeAction.java 2013-10-19 ����12:54:08 Logistics
 */
package com.survey.action;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.survey.model.Answer;
import com.survey.model.Question;
import com.survey.model.Survey;
import com.survey.model.User;

/**
 * HomeAction
 * @author wang
 * @version 1.0
 *
 */
@Component("homeAction")
@Scope("prototype")
public class HomeAction extends BaseAction {
    private Survey survey;

    private List<Survey> surveyList;

    private Question question;

    private List<Question> questionList;

    private List<Answer> answerList;

    private List<User> answeredUser;

    private String newPassword1, newPassword2, oldPassword;

    public String index() {
        surveyList = surveyService.list();
        return SUCCESS;
    }

    public String reg() {
        if (user == null) {
            return INPUT;
        }
        if (!StringUtils.equals(newPassword1, newPassword2)) {
            msg = "���벻һ��";
            return ERROR;
        }
        user.setPassword(newPassword1);
        userService.regUser(user);
        return SUCCESS;
    }

    public String login() {
        if (user == null) {
            return INPUT;
        }
        loginUser = userService.login(user);
        if (loginUser == null) {
            msg = "�������";
            return ERROR;
        }
        return SUCCESS;
    }

    public String password() {
        if (loginUser == null) {
            return LOGIN;
        }
        if (oldPassword == null) {
            return INPUT;
        }
        if (!loginUser.getPassword().equals(oldPassword)) {
            msg = "ԭʼ�������";
            return ERROR;
        }
        if (!StringUtils.equals(newPassword1, newPassword2)) {
            msg = "�����벻һ��";
            return ERROR;
        }
        loginUser.setPassword(newPassword1);
        userService.update(loginUser);
        return SUCCESS;
    }

    public String logout() {
        loginUser = null;
        return SUCCESS;
    }

    public String addSurvey() {
        if (survey == null) {
            return INPUT;
        }
        survey.setDate(new Date());
        surveyService.save(survey);
        return SUCCESS;
    }

    public String showQuestion() {
        survey = surveyService.getEntityById(survey.getId());
        questionList = survey.getQuestionList();
        return SUCCESS;
    }

    public String addQuestion() {
        if (question == null) {
            return INPUT;
        }
        question.setSurvey(survey);
        questionService.save(question);
        return SUCCESS;
    }

    public String start() {
        survey = surveyService.getEntityById(survey.getId());
        questionList = survey.getQuestionList();
        if (answerList == null) {
            return INPUT;
        }
        for (Answer a : answerList) {
            a.setUser(loginUser);
            answerService.save(a);
        }
        survey.getAnsweredUser().add(loginUser);
        surveyService.update(survey);
        return SUCCESS;
    }

    public String showAnsweredUser() {
        survey = surveyService.getEntityById(survey.getId());
        return SUCCESS;
    }

    public String showAnswer() {
        user = userService.getEntityById(user.getId());
        survey = surveyService.getEntityById(survey.getId());
        answerList = answerService.getAnswerBySurvey(survey, user);
        return SUCCESS;
    }

    /**
     * ����  survey
     * @return survey
     */
    public Survey getSurvey() {
        return survey;
    }

    /**
     * ���� survey
     * @param survey survey
     */
    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    /**
     * ����  surveyList
     * @return surveyList
     */
    public List<Survey> getSurveyList() {
        return surveyList;
    }

    /**
     * ���� surveyList
     * @param surveyList surveyList
     */
    public void setSurveyList(List<Survey> surveyList) {
        this.surveyList = surveyList;
    }

    /**
     * ����  question
     * @return question
     */
    public Question getQuestion() {
        return question;
    }

    /**
     * ���� question
     * @param question question
     */
    public void setQuestion(Question question) {
        this.question = question;
    }

    /**
     * ����  questionList
     * @return questionList
     */
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
     * ����  answerList
     * @return answerList
     */
    public List<Answer> getAnswerList() {
        return answerList;
    }

    /**
     * ���� answerList
     * @param answerList answerList
     */
    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    /**
     * ����  answeredUser
     * @return answeredUser
     */
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

    /**
     * ����  newPassword1
     * @return newPassword1
     */
    public String getNewPassword1() {
        return newPassword1;
    }

    /**
     * ���� newPassword1
     * @param newPassword1 newPassword1
     */
    public void setNewPassword1(String newPassword1) {
        this.newPassword1 = newPassword1;
    }

    /**
     * ����  newPassword2
     * @return newPassword2
     */
    public String getNewPassword2() {
        return newPassword2;
    }

    /**
     * ���� newPassword2
     * @param newPassword2 newPassword2
     */
    public void setNewPassword2(String newPassword2) {
        this.newPassword2 = newPassword2;
    }

    /**
     * ����  oldPassword
     * @return oldPassword
     */
    public String getOldPassword() {
        return oldPassword;
    }

    /**
     * ���� oldPassword
     * @param oldPassword oldPassword
     */
    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
}
