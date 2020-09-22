package com.ulearing.versionmanagement.user.controller;

import com.ulearing.versionmanagement.config.annotation.PassToken;
import com.ulearing.versionmanagement.enums.ResultEnum;
import com.ulearing.versionmanagement.result.Result;
import com.ulearing.versionmanagement.result.ResultVo;
import com.ulearing.versionmanagement.user.dto.LoginDTO;
import com.ulearing.versionmanagement.user.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2020/9/17
 * tanhao
 */

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    @PassToken
    @ApiImplicitParam(name = "Authorization", access = "hidden")
    public ResultVo login(@RequestBody LoginDTO loginDTO) {
        try {
            return userService.login(loginDTO);
        } catch (Exception e) {
            return Result.error(ResultEnum.LOGIN_DEFAULT.getCode(), e.getMessage());
        }
    }
}
