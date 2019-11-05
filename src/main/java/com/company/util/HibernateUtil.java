package com.company.util;

import com.company.domain.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.List;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public List<Person> findAll() {
        //return openSession().createQuery("from person").list();
        return openSession().createQuery("from Person").list();
    }

    public Person findFirst() {
        Query query = openSession().createQuery("from Person where id=1");

        try {
            return (Person) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Person findById(int id) {
        Query query = openSession().createQuery("from Person where id=:id");
        query.setParameter("id", id);

        try {
            return (Person) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public static SessionFactory getSession() {
        return sessionFactory;
    }

    public static Session openSession() {
        return sessionFactory.openSession();
    }

    public static void closeSession() {
        sessionFactory.close();
    }
}