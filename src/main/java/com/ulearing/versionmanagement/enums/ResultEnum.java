package com.ulearing.versionmanagement.enums;

/**
 * 返回信息枚举
 * @Desc
 * @Author chenkun
 * @Date 2020-09-17 15:20
 */
public enum ResultEnum implements CodeEnum {

    /*通用*/
    SUCCESS(200, "操作成功！"),
    FAILED(400, "操作失败！"),
    PARAM_ERROR(401, "参数错误！"),
    SERVER_ERROR(500, "服务器错误！"),

    /*登录相关*/
    LOGIN_OUT(1001,"token失效，请重新登陆！"),
    LOGIN_DEFAULT(1002,"登录失败！"),
    LOGIN_ERROR(1003, "账户或密码错误！"),
    USER_NOT_EXIST(1004, "该账号不存在！"),
    ;

    private ResultEnum(Integer code, String msg) {
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
