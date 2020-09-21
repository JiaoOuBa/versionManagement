package com.ulearing.versionmanagement.user.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 * 2020/9/8
 * tanhao
 */
public class UserModel implements Serializable {

    private Integer id;// 主键
    private String name;// 姓名
    private String loginName;// 登录名
    private String password;// 密码
    private Integer roleId;// 角色id
    private Date createTime;// 创建时间

    public UserModel(Integer id, String name, String loginName, String password, Integer roleId, Date createTime) {
        this.id = id;
        this.name = name;
        this.loginName = loginName;
        this.password = password;
        this.roleId = roleId;
        this.createTime = createTime;
    }

    public UserModel() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
