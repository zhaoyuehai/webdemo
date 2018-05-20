package com.yuehai.webdemo.www.controller;

import com.alibaba.fastjson.JSON;
import com.yuehai.webdemo.www.entities.BaseEntity;
import com.yuehai.webdemo.www.entities.UserEntity;
import com.yuehai.webdemo.www.entities.UserResultEntity;
import com.yuehai.webdemo.www.entities.UsersResultEntity;
import com.yuehai.webdemo.www.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * Created by 月海 2018/5/10
 */
@Controller
@RequestMapping("/user")//访问时url位置
@Scope("prototype")//SpringMVC实例默认情况下都是单例模式，使用scope域将其注解为每次创建新的实例
public class UserController {

    @Autowired
    private IUserService userService;

    @ResponseBody
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public BaseEntity addUser(@RequestBody String data) {
        System.out.println("------data:" + data);
        BaseEntity entity = new BaseEntity();
        UserEntity userEntity = JSON.parseObject(data, UserEntity.class);
        if (userEntity != null) {
            userService.addUser(userEntity);
            entity.setCode(0);
            entity.setMessage("添加成功");
        } else {
            entity.setCode(1);
            entity.setMessage("添加失败");
        }
        return entity;
    }

    @ResponseBody
    @RequestMapping("/getUserList")
    public BaseEntity getUserList() {
        List<UserEntity> userList = userService.getUserList();
        if (userList != null && userList.size() > 0) {
            UsersResultEntity entity = new UsersResultEntity();
            entity.setCode(0);
            entity.setMessage("success");
            entity.setList(userList);
            return entity;
        } else {
            BaseEntity entity = new BaseEntity();
            entity.setCode(1);
            entity.setMessage("无数据");
            return entity;
        }
    }

    @ResponseBody
    @RequestMapping("/deleteUserById")
    public BaseEntity deleteUserById(@RequestParam("id") int id) {
        boolean isDelete = userService.deleteUserById(id);
        BaseEntity entity = new BaseEntity();
        entity.setCode(isDelete ? 1 : 0);
        entity.setMessage(isDelete ? "删除成功" : "删除失败");
        return entity;
    }

    @ResponseBody
    @RequestMapping("/findUserById")
    public BaseEntity findUserById(@RequestParam("id") int id) {
        UserEntity user = userService.findUserById(id);
        if (user != null) {
            UserResultEntity entity = new UserResultEntity();
            entity.setCode(0);
            entity.setMessage("success");
            entity.setUser(user);
            return entity;
        } else {
            BaseEntity entity = new BaseEntity();
            entity.setCode(1);
            entity.setMessage("无数据");
            return entity;
        }
    }

    @RequestMapping("/login")
    public String login(UserEntity user, HttpServletRequest request) {
        return "login";
    }

    @RequestMapping("/login.do")
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
