package org.example;

import org.example.DAO.CarDAO;
import org.example.model.Car;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        CarDAO carDAO=new CarDAO(new Configuration().configure().addAnnotatedClass(Car.class).buildSessionFactory());
        System.out.println(carDAO.getList().size());
    }
}