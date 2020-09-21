package com.ulearing.versionmanagement.user.dto;

import com.ulearing.versionmanagement.user.model.UserModel;

/**
 * @Desc
 * @Author chenkun
 * @Date 2020-09-21 14:46
 */
public class TokenDTO {

    private UserModel user;
    private String insertTime;
    private String token;

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public String getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(String insertTime) {
        this.insertTime = insertTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
