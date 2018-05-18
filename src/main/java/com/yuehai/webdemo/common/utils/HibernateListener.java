package com.yuehai.webdemo.common.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by 月海 2018/5/18
 */
public class HibernateListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent arg0) {
        HibernateSessionFactory.closeSessionFactory();
    }

    public void contextInitialized(ServletContextEvent arg0) {

    }

}
