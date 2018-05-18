package com.yuehai.webdemo.www.entities;

import java.util.List;

/**
 * Created by 月海 2018/5/18
 */
public class UsersResultEntity extends BaseEntity{

    private List<UserEntity> list;

    public List<UserEntity> getList() {
        return list;
    }

    public void setList(List<UserEntity> list) {
        this.list = list;
    }

}
