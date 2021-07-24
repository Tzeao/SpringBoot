package com.tzeao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {
        session.setAttribute("loginUser",username);
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","用户名或密码错误");
            return "index";
        }
    }
}
