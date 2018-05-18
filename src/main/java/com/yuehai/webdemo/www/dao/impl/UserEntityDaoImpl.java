package com.yuehai.webdemo.www.dao.impl;

import com.yuehai.webdemo.common.utils.HibernateSessionFactory;
import com.yuehai.webdemo.www.dao.IUserEntityDao;
import com.yuehai.webdemo.www.entities.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by 月海 2018/5/10
 */
@Repository("userEntityDao")
@Transactional
public class UserEntityDaoImpl implements IUserEntityDao {
    @Override
    public boolean addUser(UserEntity user) {
        return false;
    }

    @Override
    public boolean deleteUserById(int id) {
        Session session = HibernateSessionFactory.getSession();
        boolean isOK = false;
        UserEntity entity = session.get(UserEntity.class, id);
        if (entity != null) {
            Transaction transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
            isOK = true;
        }
        session.close();
        return isOK;
    }

    @Override
    public boolean updateUser(UserEntity user) {
        return false;
    }

    @Override
    public UserEntity findUserById(int id) {
        UserEntity userEntity = null;
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query<UserEntity> query = session.createQuery("from UserEntity where id=" + id, UserEntity.class);
            userEntity = query.uniqueResult();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return userEntity;
    }

    @Override
    public List<UserEntity> getUserList() {
        List<UserEntity> list = null;
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query<UserEntity> query = session.createQuery("from UserEntity ", UserEntity.class);
            list = query.list();
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return list;
    }
}
