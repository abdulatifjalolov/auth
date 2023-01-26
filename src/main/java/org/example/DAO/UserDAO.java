package org.example.DAO;

import org.example.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;

import java.util.List;

public class UserDAO implements BaseDao<Users>{

    private final LocalSessionFactoryBean sessionFactory;
    public UserDAO(LocalSessionFactoryBean sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Users getById(int id) {
        Session session = sessionFactory.getConfiguration().buildSessionFactory().openSession();
        session.beginTransaction();
        Users users = session.get(Users.class, id);
        closeSession(session);
        return users;
    }

    @Override
    public void add(Users user) {
        Session session = sessionFactory.getConfiguration().buildSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        closeSession(session);
    }

    @Override
    public List<Users> getList() {
        Session session = sessionFactory.getConfiguration().buildSessionFactory().openSession();
        session.beginTransaction();
        List<Users> list = session.createCriteria(Users.class).list();
        closeSession(session);
        return list;
    }

    @Override
    public void delete(Users users) {
        Session session = sessionFactory.getConfiguration().buildSessionFactory().openSession();
        session.delete(users);
        closeSession(session);
    }
}
