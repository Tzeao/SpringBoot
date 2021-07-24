package com.tzeao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {

    //    解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
//        获取请求里面的参数
        String language = httpServletRequest.getParameter("l");
//  获取默认的语言请求,如果下面的不成立，就返回默认语言
        Locale locale = Locale.getDefault();
//  判断是否为空

        if (!StringUtils.isEmpty(language)) {
//  不为空
//            分割字符串
            String[] s = language.split("_");//  数组里面就两个东西，国家，地区
           locale =  new Locale(s[0], s[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
