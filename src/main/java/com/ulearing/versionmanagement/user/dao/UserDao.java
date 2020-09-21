package com.ulearing.versionmanagement.user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @Desc
 * @Author chenkun
 * @Date 2020-09-18 14:20
 */
@Component
@Mapper
public interface UserDao {

    @Select("select name from u_user_tab where id = #{id}")
    String getUserName(Integer id);
}
