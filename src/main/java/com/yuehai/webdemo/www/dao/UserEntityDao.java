package com.yuehai.webdemo.www.dao;

import com.yuehai.webdemo.www.entities.UserEntity;

/**
 * Created by 月海 2018/5/10
 */
public interface UserEntityDao {


    boolean addUser(UserEntity user);

    boolean deleteUserById(int id);

    boolean updateUser(UserEntity user);

    UserEntity getUserById(int id);
}
