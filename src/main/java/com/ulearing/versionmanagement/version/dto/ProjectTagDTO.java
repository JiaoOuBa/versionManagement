package com.ulearing.versionmanagement.version.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Desc
 * @Author chenkun
 * @Date 2020-09-21 09:00
 */
public class ProjectTagDTO {

    @ApiModelProperty("项目id")
    private Integer id;

    @ApiModelProperty("项目名称")
    private String name;

    @ApiModelProperty("该项目的最新版本号")
    private String newTag;

    public ProjectTagDTO() {
    }

    public ProjectTagDTO(Integer id, String name, String newTag) {
        this.id = id;
        this.name = name;
        this.newTag = newTag;
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

    public String getNewTag() {
        return newTag;
    }

    public void setNewTag(String newTag) {
        this.newTag = newTag;
    }
}
