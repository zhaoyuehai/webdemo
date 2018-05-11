package com.yuehai.webdemo.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 月海 2018/5/10
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
