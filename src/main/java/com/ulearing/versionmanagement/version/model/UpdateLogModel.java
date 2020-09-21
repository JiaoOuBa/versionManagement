package com.ulearing.versionmanagement.version.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * 更新记录
 * 2020/9/8
 * tanhao
 */
public class UpdateLogModel implements Serializable {

    private Integer id;// 主键id
    private Integer devUserId;// 开发人员id
    private String description;// 更新描述
    private Integer status;// 状态（1 待更新，2 已更新）
    private Integer opsUserId;// 运维人员id
    private Integer region;// 区域
    private Date createTime;// 创建时间
    private Date updateTime;// 最后修改时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDevUserId() {
        return devUserId;
    }

    public void setDevUserId(Integer devUserId) {
        this.devUserId = devUserId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOpsUserId() {
        return opsUserId;
    }

    public void setOpsUserId(Integer opsUserId) {
        this.opsUserId = opsUserId;
    }

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
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
