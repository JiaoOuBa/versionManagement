package com.ulearing.versionmanagement.exception;

import com.ulearing.versionmanagement.enums.ResultEnum;

/**
 * 全局异常
 * @Auther chenkun
 * @Date 2020/9/21 17:10
 * @Desc
 */
public class GlobalException extends RuntimeException {

    private static final long serialVersionUID = 1L;


    private ResultEnum em;


    public GlobalException(ResultEnum exceptionMsg) {
        super(exceptionMsg.toString());


        this.em = exceptionMsg;
    }


    public ResultEnum getEm() {
        return em;
    }
}
