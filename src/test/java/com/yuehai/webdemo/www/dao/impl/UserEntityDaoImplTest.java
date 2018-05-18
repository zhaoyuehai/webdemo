package com.yuehai.webdemo.www.dao.impl;

import com.yuehai.webdemo.www.entities.UserEntity;
import org.junit.Test;

import java.util.List;

/**
 * Created by 月海 2018/5/10
 */
public class UserEntityDaoImplTest {
    @Test
    public void getUserById(){
        UserEntityDaoImpl userEntityDao = new UserEntityDaoImpl();
        UserEntity user = userEntityDao.findUserById(1);
        System.out.print("---------UserName:" + user.getUserName());
    }
    @Test
    public void getUserList(){
        UserEntityDaoImpl userEntityDao = new UserEntityDaoImpl();
        List<UserEntity> userList = userEntityDao.getUserList();
        System.out.print("---------userList:" +userList.toString());
    }
}