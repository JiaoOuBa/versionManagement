package com.ulearing.versionmanagement.exception;

import com.mysql.cj.util.LogUtils;
import com.ulearing.versionmanagement.enums.ResultEnum;
import com.ulearing.versionmanagement.result.ResultVo;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.BindException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 全局异常处理类
 * @Auther ck
 * @Date 2020/9/21 17:14
 * @Desc 用于全局返回json
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<Object>(handlerException(ex), HttpStatus.OK);
    }


    /**
     * 进入控制器后的异常捕获
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultVo handlerException(Exception e) {

        e.printStackTrace();
        ResultVo restResult = new ResultVo();

        if (e instanceof GlobalException) {
            GlobalException ex = (GlobalException) e;
            restResult.setCode(ex.getEm().getCode());
            restResult.setMessage(ex.getEm().getMsg());
        } else if (e instanceof BindException) {
            org.springframework.validation.BindException ex = (org.springframework.validation.BindException)e;
            List<String> errors = ex.getAllErrors().stream().map(p -> p.getDefaultMessage()).collect(Collectors.toList());
            restResult.setMessage(errors.get(0));
            restResult.setCode(ResultEnum.PARAM_ERROR.getCode());
        } else if(e instanceof MethodArgumentNotValidException) {
            List<String> errors = new ArrayList();
            MethodArgumentNotValidException mex = (MethodArgumentNotValidException) e;
            List<ObjectError> allErrors = mex.getBindingResult().getAllErrors();
            for (int i = 0; i < allErrors.size(); i++) {
                errors.add(allErrors.get(i).getDefaultMessage());
            }
            restResult.setMessage(errors.get(0));
            restResult.setCode(ResultEnum.PARAM_ERROR.getCode());
        } else if(e instanceof BadSqlGrammarException) {
            BadSqlGrammarException ex = (BadSqlGrammarException) e;
            restResult.setMessage(ResultEnum.SERVER_ERROR.getMsg() + ex.getCause().getMessage());
        } else {
            restResult.setCode(ResultEnum.SERVER_ERROR.getCode());
            StackTraceElement stackTrace = e.getStackTrace()[0];
            restResult.setMessage(ResultEnum.SERVER_ERROR.getMsg() + ",文件名：" + stackTrace.getFileName()+"行："+stackTrace.getLineNumber());
        }
        // TODO: 2020-09-21 日志
        return restResult;
    }
}
