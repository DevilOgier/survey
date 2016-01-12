package com.survey.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.survey.model.User;
import com.survey.service.AnswerService;
import com.survey.service.QuestionService;
import com.survey.service.SurveyService;
import com.survey.service.UserService;

public class BaseAction extends ActionSupport implements SessionAware {

    @Resource(name = "userService")
    protected UserService userService;

    @Resource(name = "surveyService")
    protected SurveyService surveyService;

    @Resource(name = "questionService")
    protected QuestionService questionService;

    @Resource(name = "answerService")
    protected AnswerService answerService;

    //���õ�ҳ�����
    protected User user;

    protected User loginUser;

    protected String msg;

    protected Integer id;

    protected int pageNo;

    protected int pageSize = 12;

    protected Map<String, Object> session;

    protected ValueStack getValueStack() {
        return ActionContext.getContext().getValueStack();
    }

    /**
     * ����  user
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * ���� user
     * @param user user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * ����  msg
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * ���� msg
     * @param msg msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * ����  id
     * @return id
     */
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
     * ����  pageNo
     * @return pageNo
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * ���� pageNo
     * @param pageNo pageNo
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * ����  loginUser
     * @return loginUser
     */
    public User getLoginUser() {
        return loginUser;
    }

    /**
     * ���� loginUser
     * @param loginUser loginUser
     */
    public void setLoginUser(User loginUser) {
        this.loginUser = loginUser;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
