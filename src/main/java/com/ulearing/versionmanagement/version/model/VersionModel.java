package com.ulearing.versionmanagement.version.model;

import java.io.Serializable;

/**
 * 版本列表
 * 2020/9/8
 * tanhao
 */
public class VersionModel implements Serializable{

    private Integer id;// 主键
    private Integer logId;// 日志id
    private Integer region;// 区域
    private Integer projectId;// 项目id
    private String version;// 版本

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
