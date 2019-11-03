package com.company.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static SessionFactory getSession() {
        return sessionFactory;
    }

    public static void closeSession() {
        getSession().close();
    }
}