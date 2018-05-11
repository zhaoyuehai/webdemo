package com.yuehai.webdemo.www.service.impl;

import com.yuehai.webdemo.www.dao.IUserEntityDao;
import com.yuehai.webdemo.www.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
