package com.ulearing.versionmanagement.version.model;

import java.io.Serializable;

/**
 * 项目
 * 2020/9/8
 * tanhao
 */
public class ProjectModel implements Serializable {

    private Integer id;// 主键
    private String name;// 项目名称
    private String description;// 描述
    private String path;// svn路径
    private Integer region;// 1 cn(大陆),2 asia(新加坡),3 pro(圣地亚哥),4 app(墨西哥),5 net(南非)

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }
}
