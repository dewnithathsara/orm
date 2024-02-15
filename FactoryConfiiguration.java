package org.example.config;

import org.example.entity.Author;
import org.example.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {  private static FactoryConfiguration factoryconfiguration;
    private SessionFactory sessionFactory;
    private FactoryConfiguration() {
        Configuration config = new Configuration().configure().addAnnotatedClass(Author.class).addAnnotatedClass(Book.class);
        sessionFactory= config.buildSessionFactory();
    }
    public static FactoryConfiguration getInstance(){
        return factoryconfiguration==null? factoryconfiguration=new FactoryConfiguration(): factoryconfiguration;
    }
    public Session getSession(){
        return sessionFactory.openSession();
    }

}
