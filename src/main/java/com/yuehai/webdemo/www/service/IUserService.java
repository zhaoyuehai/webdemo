package com.yuehai.webdemo.www.service;

/**
 * Created by 月海 2018/5/11
 */
public interface IUserService {
    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户信息
     */
    boolean login(String username, String password);
}
