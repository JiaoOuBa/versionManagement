package com.ulearing.versionmanagement.version.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * @Desc
 * @Author chenkun
 * @Date 2020-09-18 14:04
 */
public class CommitLogRequest {

    @ApiModelProperty("区域")
    @NotNull
    private Integer region;
    @ApiModelProperty("更新说明")
    @NotNull
    private String description;
    @ApiModelProperty("提交人")
    private Integer devUserId;

    @ApiModelProperty("状态（1.待更新，2.已更新）")
    @JsonIgnore
    private Integer status;
    @ApiModelProperty("提交时间")
    @JsonIgnore
    private Date createTime;

    @ApiModelProperty("项目-版本信息")
    private List<ProjectVersionDTO> projectVersionList;

    public CommitLogRequest(Integer region, String description, Integer devUserId, Integer status, Date createTime, List<ProjectVersionDTO> projectVersionList) {
        this.region = region;
        this.description = description;
        this.devUserId = devUserId;
        this.status = status;
        this.createTime = createTime;
        this.projectVersionList = projectVersionList;
    }

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDevUserId() {
        return devUserId;
    }

    public void setDevUserId(Integer devUserId) {
        this.devUserId = devUserId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<ProjectVersionDTO> getProjectVersionList() {
        return projectVersionList;
    }

    public void setProjectVersionList(List<ProjectVersionDTO> projectVersionList) {
        this.projectVersionList = projectVersionList;
    }
}
