package com.ulearing.versionmanagement.user.dto;

import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Desc
 * @Author chenkun
 * @Date 2020-09-21 14:19
 */
public class LoginDTO {

    @ApiModelProperty("登录名")
    private String loginName;
    @ApiModelProperty("密码")
    private String password;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
