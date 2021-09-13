package com.example.examplemultdatasource.bean;

import java.util.Date;

public class UserBean {
    private Long autoId;

    private String username;

    private String password;

    private String realname;

    private String state;

    private Date createtime;

    public UserBean(Long autoId, String username, String password, String realname, String state, Date createtime) {
        this.autoId = autoId;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.state = state;
        this.createtime = createtime;
    }

    public UserBean() {
        super();
    }

    public Long getAutoId() {
        return autoId;
    }

    public void setAutoId(Long autoId) {
        this.autoId = autoId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}