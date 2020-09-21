package com.ulearing.versionmanagement.config.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.interfaces.Claim;
import com.ulearing.versionmanagement.config.UserContext;
import com.ulearing.versionmanagement.config.annotation.PassToken;
import com.ulearing.versionmanagement.enums.ResultEnum;
import com.ulearing.versionmanagement.exception.GlobalException;
import com.ulearing.versionmanagement.redis.RedisService;
import com.ulearing.versionmanagement.redis.key.TokenKey;
import com.ulearing.versionmanagement.user.dto.AdminUserDTO;
import com.ulearing.versionmanagement.user.service.AdminTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * token拦截
 * @Desc
 * @Author chenkun
 * @Date 2020-09-21 15:21
 */
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

        String tokenStr = request.getHeader(CommonConstant.HEADER_AUTHORIZATION);
        String traceIdStr = request.getHeader(CommonConstant.HEADER_TRACE_ID);
        UserContext.setUserTraceId(traceIdStr);

        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();

        // 检查是否有PassToken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }

        // 执行认证
        if (tokenStr == null || !tokenStr.startsWith(CommonConstant.BEARER_AUTHENTICATION)) {
            throw new GlobalException(ResultEnum.LOGIN_OUT);
        }

        // 从http请求头中取出 token
        String token = tokenStr.split(" ")[1];
        UserContext.getAdminUserToken().set(token);
        AdminUserDTO userInfo =checkToken(token);
        UserContext.setAdminId(userInfo.getId() + "");
        UserContext.getAdminUserToken().set(userInfo.getToken());
        UserContext.getAdminUserInfo().set(userInfo);

        response.setHeader(CommonConstant.HEADER_AUTHORIZATION, userInfo.getToken());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    private AdminUserDTO checkToken(String token) {

        if (token == null) {
            throw new GlobalException(ResultEnum.LOGIN_OUT);
        }
        Map<String, Claim> tokenMap = AdminTokenService.verifyToken(token);
        Integer adminId = tokenMap.get("id").asInt();
        String res = redisService.get(TokenKey.getByToken, adminId+ "");
        if (res == null) {
            throw new GlobalException(ResultEnum.LOGIN_OUT);
        }
        // 将用户信息转换成java对象
        JSONObject jsonObject = JSON.parseObject(res);
        JSONObject obj = (JSONObject) jsonObject.get("adminLoginResponse");
        AdminUserDTO login = JSONObject.toJavaObject(obj, AdminUserDTO.class);
        return login;
    }
}
