package org.example.DAO;

import org.example.model.Car;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CarDAO implements BaseDao<Car>{
    private final SessionFactory sessionFactory;
    public CarDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Car getById(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Car car = session.get(Car.class, id);
        closeSession(session,sessionFactory);
        return car;
    }
    @Override
    public void add(Car car){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(car);
        closeSession(session,sessionFactory);
    }
    @Override
    public List<Car> getList(){
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        List<Car> list = session.createCriteria(Car.class).list();
        closeSession(session,sessionFactory);
        return list;
    }
    @Override
    public void delete(Car car){
        Session session = sessionFactory.openSession();
        session.delete(car);
        closeSession(session,sessionFactory);
    }
}
