package org.example.DAO;

import org.example.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDAO implements BaseDao<Users>{

    private final SessionFactory sessionFactory;
    public UserDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Users getById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Users users = session.get(Users.class, id);
        closeSession(session);
        return users;
    }

    @Override
    public void add(Users user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        closeSession(session);
    }

    @Override
    public List<Users> getList() {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        List<Users> list = session.createCriteria(Users.class).list();
        closeSession(session);
        return list;
    }

    @Override
    public void delete(Users users) {
        Session session = sessionFactory.openSession();
        session.delete(users);
        closeSession(session);
    }
}
