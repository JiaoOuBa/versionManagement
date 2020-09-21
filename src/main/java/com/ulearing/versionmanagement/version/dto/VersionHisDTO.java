package com.ulearing.versionmanagement.version.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Desc
 * @Author chenkun
 * @Date 2020-09-21 10:51
 */
public class VersionHisDTO {

    @ApiModelProperty("区域")
    private Integer region;
    @ApiModelProperty("项目id")
    private Integer projectId;
    @ApiModelProperty("项目名称")
    private String projectName;

    /* log记录相关字段 */
    @JsonIgnore
    private Integer devUserId;
    @JsonIgnore
    private Integer opsUserId;
    @ApiModelProperty("开发人员")
    private String devUserName;
    @ApiModelProperty("运维人员")
    private String opsUserName;
    @ApiModelProperty("更新说明")
    private String description;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("更新时间")
    private Date updateTime;

    /* 版本相关字段 */
    @ApiModelProperty("版本")
    private String version;

    public VersionHisDTO() {
    }

    public VersionHisDTO(Integer region, Integer projectId, String projectName, Integer devUserId, Integer opsUserId, String devUserName, String opsUserName, String description, Date createTime, Date updateTime, String version) {
        this.region = region;
        this.projectId = projectId;
        this.projectName = projectName;
        this.devUserId = devUserId;
        this.opsUserId = opsUserId;
        this.devUserName = devUserName;
        this.opsUserName = opsUserName;
        this.description = description;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.version = version;
    }

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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
}
