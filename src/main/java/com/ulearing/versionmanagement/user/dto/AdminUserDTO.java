package com.ulearing.versionmanagement.user.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Desc
 * @Author chenkun
 * @Date 2020-09-21 14:55
 */
public class AdminUserDTO {

    @ApiModelProperty("用户id")
    private Integer id;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("登录名")
    private String loginName;
    @ApiModelProperty("角色（1.开发人员，2.运维人员）")
    private Integer roleId;
    @ApiModelProperty("登录token")
    private String token;

    public AdminUserDTO() {
    }

    public AdminUserDTO(Integer id, String name, String loginName, Integer roleId, String token) {
        this.id = id;
        this.name = name;
        this.loginName = loginName;
        this.roleId = roleId;
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
