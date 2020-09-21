package com.ulearing.versionmanagement.enums;

/**
 * @Desc
 * @Author chenkun
 * @Date 2020-09-18 15:21
 */
public enum LogStatusEnum implements CodeEnum{

    STATUS_DGX(1, "待更新"),
    STATUS_YGX(2, "已更新"),
    ;

    private LogStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String msg;

    @Override
    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
