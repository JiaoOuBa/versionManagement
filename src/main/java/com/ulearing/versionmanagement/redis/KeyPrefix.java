package com.ulearing.versionmanagement.redis;

/**
 * reids前缀配置
 * @Auther ck
 * @Date 2020/9/17 15:54
 * @Desc
 */
public interface KeyPrefix {

    /**
     * redis 过期时间
     * @return 过期时间
     */
    int expireSeconds();

    /**
     * redis key
     * @return 键前缀
     */
    String getPrefix();
}
