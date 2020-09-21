package com.ulearing.versionmanagement.version.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 更新日志
 * 2020/9/8
 * tanhao
 */
public class UpdateLogDTO implements Serializable {

    @ApiModelProperty("主键id")
    private Integer id;
    @ApiModelProperty("更新说明")
    private String description;
    @ApiModelProperty("提交人")
    private String devUserName;
    @ApiModelProperty("更新人")
    private String opsUserName;
    @ApiModelProperty("状态（1.待更新，2.已更新）")
    private Integer status;
    @ApiModelProperty("提交时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;
    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date updateTime;
    @ApiModelProperty("区域")
    private Integer region;

    @JsonIgnore
    private Integer devUserId;
    @JsonIgnore
    private Integer opsUserId;


    public UpdateLogDTO() {
    }

    public UpdateLogDTO(Integer id, String description, String devUserName, String opsUserName, Integer status, Date createTime, Date updateTime, Integer region) {
        this.id = id;
        this.description = description;
        this.devUserName = devUserName;
        this.opsUserName = opsUserName;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.region = region;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDevUserName() {
        return devUserName;
    }

    public void setDevUserName(String devUserName) {
        this.devUserName = devUserName;
    }

    public String getOpsUserName() {
        return opsUserName;
    }

    public void setOpsUserName(String opsUserName) {
        this.opsUserName = opsUserName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    public Integer getDevUserId() {
        return devUserId;
    }

    public void setDevUserId(Integer devUserId) {
        this.devUserId = devUserId;
    }

    public Integer getOpsUserId() {
        return opsUserId;
    }

    public void setOpsUserId(Integer opsUserId) {
        this.opsUserId = opsUserId;
    }
}
