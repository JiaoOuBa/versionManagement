package com.ulearing.versionmanagement.version.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Desc
 * @Author chenkun
 * @Date 2020-09-21 13:18
 */
public class ProjectVersionDTO {

    @ApiModelProperty("项目id")
    @NotNull
    private Integer projectId;

    @ApiModelProperty("版本")
    @NotNull
    private String version;

    @ApiModelProperty("日志id")
    @JsonIgnore
    private Integer logId;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }
}
