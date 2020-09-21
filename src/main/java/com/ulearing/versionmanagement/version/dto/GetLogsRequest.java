package com.ulearing.versionmanagement.version.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Desc
 * @Author chenkun
 * @Date 2020-09-18 11:28
 */
public class GetLogsRequest {

    @ApiModelProperty("页码，默认1")
    private Integer page = 1;

    @ApiModelProperty("每页记录数，默认10")
    private Integer pageSize = 10;

    @ApiModelProperty("区域")
    private Integer region;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }
}
