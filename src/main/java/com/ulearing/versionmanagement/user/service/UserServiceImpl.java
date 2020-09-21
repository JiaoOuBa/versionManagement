package com.ulearing.versionmanagement.user.service;

import com.ulearing.versionmanagement.enums.ResultEnum;
import com.ulearing.versionmanagement.redis.RedisService;
import com.ulearing.versionmanagement.redis.key.TokenKey;
import com.ulearing.versionmanagement.result.Result;
import com.ulearing.versionmanagement.result.ResultVo;
import com.ulearing.versionmanagement.user.dao.UserDao;
import com.ulearing.versionmanagement.user.dto.AdminUserDTO;
import com.ulearing.versionmanagement.user.dto.LoginDTO;
import com.ulearing.versionmanagement.user.dto.TokenDTO;
import com.ulearing.versionmanagement.user.model.UserModel;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Desc
 * @Author chenkun
 * @Date 2020-09-21 11:45
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    RedisService redisService;

    @Override
    public String getUserName(Integer id) {
        if (id == null) {
            return null;
        }
        return userDao.getUserName(id);
    }

    @Override
    public ResultVo login(LoginDTO loginDTO) {
        AdminUserDTO result = new AdminUserDTO();

        if (ObjectUtils.isNotEmpty(loginDTO.getLoginName()) &&
        ObjectUtils.isNotEmpty(loginDTO.getPassword())) {
            UserModel user = userDao.getAllByLoginName(loginDTO.getLoginName());
            if (user == null) {
                return Result.error(ResultEnum.USER_NOT_EXIST.getCode());
            }
            if (!loginDTO.getPassword().equals(user.getPassword())) {
                return Result.error(ResultEnum.LOGIN_ERROR.getCode());
            }

            // 生成token
            String token = AdminTokenService.createToken(user.getId(), user.getLoginName());
            // 获取token
            getToken(user, token);

            BeanUtils.copyProperties(user, result);
            result.setToken(token);
        }
        return Result.success(result);
    }

    /**
     * 获取token并存redis
     * @param user 用户信息
     * @param token 生成的token
     */
    private void getToken(UserModel user, String token) {
        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setUser(user);
        tokenDTO.setToken(token);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(new Date());
        tokenDTO.setInsertTime(time);

        // 存redis
        TokenKey key = TokenKey.getByToken;
        redisService.set(key, user.getId() + "", tokenDTO);
    }
}
