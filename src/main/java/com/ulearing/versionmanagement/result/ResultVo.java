package com.ulearing.versionmanagement.result;

import com.ulearing.versionmanagement.enums.ResultEnum;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 信息返回封装
 * @Desc
 * @Author chenkun
 * @Date 2020-09-17 14:48
 */
public class ResultVo<T> {

    @ApiModelProperty("状态码")
    private Integer code = 200;

    @ApiModelProperty("返回的正确信息或者错误信息")
    private String message;

    @ApiModelProperty("结果集")
    private T result;


    public ResultVo(Integer code, String message, T result) {
        this.setCode(code);
        this.setMessage(message);
        this.setResult(result);
    }

    public ResultVo(T result, String message) {
        this.setMessage(message);
        this.setResult(result);
    }

    public ResultVo(Integer code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    public ResultVo(T result) {
        this.setMessage(ResultEnum.SUCCESS.getMsg());
        this.setResult(result);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResultVo{" +
                "code=" + code +
                ", message=" + message +
                ", result=" + result +
                '}';
    }
}
