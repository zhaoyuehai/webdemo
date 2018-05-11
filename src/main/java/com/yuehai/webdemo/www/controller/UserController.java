package com.yuehai.webdemo.www.controller;

import com.yuehai.webdemo.www.entities.UserEntity;
import com.yuehai.webdemo.www.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by 月海 2018/5/10
 */
@Controller
@RequestMapping("/user")//访问时url位置
@Scope("prototype")//SpringMVC实例默认情况下都是单例模式，使用scope域将其注解为每次创建新的实例
public class UserController {

    @Autowired()
    private IUserService userService;

    @RequestMapping("/login")
    public String hello(UserEntity user, HttpServletRequest request) {
        boolean isLogin = userService.login(user.getUserName(), user.getPassword());
        if (isLogin) {
            request.setAttribute("user", user);
            return "login-success";
        } else {
            request.setAttribute("message", "用户名或密码错误");
            return "login-fail";

        }
    }
}
