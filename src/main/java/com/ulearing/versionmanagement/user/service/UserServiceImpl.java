package com.ulearing.versionmanagement.user.service;

import com.ulearing.versionmanagement.user.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Desc
 * @Author chenkun
 * @Date 2020-09-21 11:45
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public String getUserName(Integer id) {
        if (id == null) {
            return null;
        }
        return userDao.getUserName(id);
    }
}
