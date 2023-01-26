package org.example.DAO;

import org.example.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;

import java.util.List;

public class CarDAO implements BaseDao<Car>{
    private final LocalSessionFactoryBean sessionFactory;
    public CarDAO(LocalSessionFactoryBean sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public Car getById(int id){
        Session session = sessionFactory.getConfiguration().buildSessionFactory().openSession();
        session.beginTransaction();
        Car car = session.get(Car.class, id);
        closeSession(session);
        return car;
    }
    @Override
    public void add(Car car){
        Session session = sessionFactory.getConfiguration().buildSessionFactory().openSession();
        session.beginTransaction();
        session.save(car);
        closeSession(session);
    }
    @Override
    public List<Car> getList(){
        Session session = sessionFactory.getConfiguration().buildSessionFactory().openSession();
        session.beginTransaction();
        List<Car> list = session.createCriteria(Car.class).list();
        closeSession(session);
        return list;
    }
    @Override
    public void delete(Car car){
        Session session = sessionFactory.getConfiguration().buildSessionFactory().openSession();
        session.delete(car);
        closeSession(session);
    }
}
