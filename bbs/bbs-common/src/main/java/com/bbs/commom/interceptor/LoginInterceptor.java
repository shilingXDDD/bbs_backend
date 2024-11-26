package com.bbs.commom.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.bbs.commom.consts.CommonConstant;
import com.bbs.commom.vo.DataResult;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//拦截器
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if(session.getAttribute(CommonConstant.SESSION_USER) == null){
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(JSONObject.toJSONString(DataResult.fail(999,"用户未登录")));
            return false;
        }
        return true;
    }
}
