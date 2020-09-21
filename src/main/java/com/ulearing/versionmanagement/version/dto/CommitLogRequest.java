package com.ulearing.versionmanagement.version.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Desc
 * @Author chenkun
 * @Date 2020-09-18 14:04
 */
public class CommitLogRequest {

    @ApiModelProperty("区域")
    private Integer region;
    @ApiModelProperty("更新说明")
    private String description;
    @ApiModelProperty("提交人")
    private Integer devUserId;
    @ApiModelProperty("更新人")
    private Integer opsUserId;

    @ApiModelProperty("状态（1.待更新，2.已更新）")
    @JsonIgnore
    private Integer status;
    @ApiModelProperty("提交时间")
    @JsonIgnore
    private Date createTime;
    @ApiModelProperty("更新时间")
    @JsonIgnore
    private Date updateTime;

    public CommitLogRequest(Integer region, String description, Integer devUserId, Integer opsUserId, Integer status, Date createTime, Date updateTime) {
        this.region = region;
        this.description = description;
        this.devUserId = devUserId;
        this.opsUserId = opsUserId;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
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

    public Integer getOpsUserId() {
        return opsUserId;
    }

    public void setOpsUserId(Integer opsUserId) {
        this.opsUserId = opsUserId;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
