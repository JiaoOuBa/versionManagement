package com.ulearing.versionmanagement.user.service;

import com.ulearing.versionmanagement.result.ResultVo;
import com.ulearing.versionmanagement.user.dto.LoginDTO;

/**
 * @Desc
 * @Author chenkun
 * @Date 2020-09-21 11:45
 */
public interface UserService {

    /**
     * 根据id获取用户名
     * @param id
     * @return
     */
    String getUserName(Integer id);

    /**
     * 后台登录
     * @param loginDTO
     * @return
     */
    ResultVo login(LoginDTO loginDTO);
}
