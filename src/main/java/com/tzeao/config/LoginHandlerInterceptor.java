package com.tzeao.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 登录拦截器
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object name = session.getAttribute("loginUser");
        if (name == null){
            request.setAttribute("msg","请登录");
            request.getRequestDispatcher("index.html").forward(request,response);
            return false;
        }else
        return true;
    }

}
