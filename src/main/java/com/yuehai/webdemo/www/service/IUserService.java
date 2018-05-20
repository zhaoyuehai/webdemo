package com.yuehai.webdemo.www.service;

import com.yuehai.webdemo.www.entities.UserEntity;

import java.util.List;

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

    List<UserEntity> getUserList();

    UserEntity findUserById(int id);

    void addUser(UserEntity userEntity);

    /**
     * 根据id删除
     *
     * @param id id
     * @return isDelete
     */
    boolean deleteUserById(int id);
}
