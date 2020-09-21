package com.ulearing.versionmanagement.redis.key;

import com.ulearing.versionmanagement.redis.BasePrefix;

/**
 * @Desc
 * @Author chenkun
 * @Date 2020-09-21 14:51
 */
public class TokenKey extends BasePrefix {

    public TokenKey(String prefix) {
        super(prefix);
    }

    public TokenKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static TokenKey getByToken = new TokenKey( 0,"token");

    public static TokenKey withExpire(int expireSeconds) {
        return new TokenKey(expireSeconds, "token");
    }
}
