package com.yuehai.webdemo.www.service.impl;

import com.yuehai.webdemo.www.dao.IUserEntityDao;
import com.yuehai.webdemo.www.entities.UserEntity;
import com.yuehai.webdemo.www.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 月海 2018/5/11
 */
@Service("userService")//注解用于标识此类为业务层组件，在使用时被注解的类会自动由spring注入，无需手动创建实例
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserEntityDao userEntityDao;

    @Override
    public boolean login(String username, String password) {
        return true;
    }

    @Override
    public List<UserEntity> getUserList() {
        return userEntityDao.getUserList();
    }

    public UserEntity findUserById(int id) {
        return userEntityDao.findUserById(id);
    }

    @Override
    public void addUser(UserEntity userEntity) {
        userEntityDao.addUser(userEntity);
    }

    @Override
    public boolean deleteUserById(int id) {
        return userEntityDao.deleteUserById(id);
    }
}
