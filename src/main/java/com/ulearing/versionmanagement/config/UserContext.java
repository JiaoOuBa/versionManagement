package com.ulearing.versionmanagement.config;

import com.ulearing.versionmanagement.user.dto.AdminUserDTO;
import com.ulearing.versionmanagement.user.model.UserModel;

/**
 * 当前线程上下文的get、set
 * @Desc
 * @Author chenkun
 * @Date 2020-09-21 15:27
 */
public class UserContext {

    private static ThreadLocal<String> userHolder = new ThreadLocal<String>();
    private static ThreadLocal<String> adminUserToken = new ThreadLocal<>();
    private static ThreadLocal<String> userTraceId = new ThreadLocal<>();
    private static ThreadLocal<AdminUserDTO> adminUserInfo = new ThreadLocal<>();

    public static void setAdminId(String adminId) {
        userHolder.set(adminId);
    }

    public static String getAdminId() {
        return userHolder.get();
    }

    public static ThreadLocal<String> getAdminUserToken() {
        return adminUserToken;
    }

    public static void setAdminUserToken(ThreadLocal<String> adminUserToken) {
        UserContext.adminUserToken = adminUserToken;
    }

    public static String getUserTraceId() {
        return userTraceId.get();
    }

    public static void setUserTraceId(String traceId) {
        userTraceId.set(traceId);
    }

    public static ThreadLocal<AdminUserDTO> getAdminUserInfo() {
        return adminUserInfo;
    }

    public static void setAdminUserInfo(ThreadLocal<AdminUserDTO> adminUserInfo) {
        UserContext.adminUserInfo = adminUserInfo;
    }

    public static void removeUserTraceId() {
        userTraceId.remove();
    }

    public static void removeAdminId() {
        userHolder.remove();
    }
}
