package org.example.DAO;

import org.hibernate.Session;


import java.util.List;

public interface BaseDao<T> {
    public T getById(int id);
    public void add(T item);

    public List<T> getList();
    public void delete(T item);
    default public void closeSession(Session session){
        session.getTransaction().commit();
        session.close();
    };
}
