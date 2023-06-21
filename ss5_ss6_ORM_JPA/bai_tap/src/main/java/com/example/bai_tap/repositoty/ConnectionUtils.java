package com.example.bai_tap.repositoty;

import org.hibernate.HibernateError;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;

public class ConnectionUtils {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        }catch (HibernateError e){
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory (){
        return sessionFactory;
    }
    public static EntityManager getEntityManager (){
        return entityManager;
    }
}
