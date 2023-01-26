package org.example.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.util.List;

public interface BaseDao<T> {
    T getById(int id);
    void add(T item);

    List<T> getList();
    void delete(T item);
    default void closeSession(Session session, SessionFactory sessionFactory){
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    };
}
