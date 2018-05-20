package com.yuehai.webdemo.www.dao;

import com.yuehai.webdemo.www.entities.UserEntity;

import java.util.List;

/**
 * Created by 月海 2018/5/10
 */
public interface IUserEntityDao {

    void addUser(UserEntity user);

    boolean deleteUserById(int id);

    boolean updateUser(UserEntity user);

    UserEntity findUserById(int id);

    List<UserEntity> getUserList();


}
