package com.yuehai.webdemo.common.utils;

import com.yuehai.webdemo.www.entities.UserEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by 月海 2018/5/10
 */
public class HibernateSessionFactory {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            //将生成的实体类加入到Configuration里（Hibernate 4.x版本不需要，5.x版本需要且必须生产.hbm.xml文件）
            //1.创建配置对象
            Configuration configuration = new Configuration().configure();
            //2.创建服务注册对象
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            configuration.addClass(UserEntity.class);
            //3.创建会话工厂对象
            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * 获取会话对象
     *
     * @return 会话对象
     * @throws HibernateException
     */
    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) {
        //
        final Session session = getSession();
        try {
            //开启事务
            session.beginTransaction();
            UserEntity userEntity = session.load(UserEntity.class, 1);
            System.out.println("----------UserName:" + userEntity.getUserName());
            System.out.println("----------Password:" + userEntity.getPassword());
            System.out.println("----------Mobile:" + userEntity.getMobile());
//            userEntity.setUserName("");
            //提交事务
            session.getTransaction().commit();
            //下面的代码是IntelliJ IDEA自动生成的，适用于Hibernate4.x,5.x不再可用，执行会报错。
//            System.out.println("querying all the managed entities...");
//            final Map metadataMap = session.getSessionFactory().getAllClassMetadata();
//            for (Object key : metadataMap.keySet()) {
//                final ClassMetadata classMetadata = (ClassMetadata) metadataMap.get(key);
//                final String entityName = classMetadata.getEntityName();
//                final Query query = session.createQuery("from " + entityName);
//                System.out.println("executing: " + query.getQueryString());
//                for (Object o : query.list()) {
//                    System.out.println("  " + o);
//                }
//            }
        } catch (Exception e) {
            Transaction transaction = session.getTransaction();
            if (transaction != null)
                transaction.rollback();
        } finally {
            if (session != null && session.isOpen())
                session.close();
//            ourSessionFactory.close();
        }
    }
}