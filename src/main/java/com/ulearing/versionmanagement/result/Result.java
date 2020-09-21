package com.ulearing.versionmanagement.result;

import com.ulearing.versionmanagement.enums.ResultEnum;

import java.util.List;

/**
 * 信息返回封装
 * @Desc
 * @Author chenkun
 * @Date 2020-09-17 15:16
 */
public class Result {

    public static <T> ResultVo<T> success(T result, String msg) {
        ResultVo<T> resultVo = new ResultVo<>(ResultEnum.SUCCESS.getCode(), msg, result);
        return resultVo;
    }

    public static ResultVo success(String msg) {
        ResultVo resultVo = new ResultVo(ResultEnum.SUCCESS.getCode(), msg);
        return resultVo;
    }

    public static <T> ResultVo<T> success(T result) {
        ResultVo<T> resultVo = new ResultVo<>(result);
        return resultVo;
    }

    public static ResultVo success() {
        ResultVo resultVo = new ResultVo(ResultEnum.SUCCESS.getCode());
        return resultVo;
    }

    public static ResultVo error(Integer code, String msg) {
        ResultVo resultVo = new ResultVo(code, msg, null);
        // LogUtil.info("流程错误", msg.toString());
        return resultVo;
    }

    public static ResultVo error(Integer code) {
        ResultVo resultVo = new ResultVo(code, null);
        // LogUtil.info("流程错误", msg.toString());
        return resultVo;
    }
}
