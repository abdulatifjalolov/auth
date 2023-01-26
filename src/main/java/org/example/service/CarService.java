package org.example.service;

import org.example.DAO.CarDAO;
import org.example.DAO.UserDAO;
import org.example.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarService implements BaseService<Car> {
    private  final CarDAO carDAO;
    private  final UserDAO userDAO;

    public CarService(CarDAO carDAO, UserDAO userDAO) {
        this.userDAO = userDAO;
        this.carDAO = carDAO;
    }

    @Override
    public Car getById(int id) {
        return null;
    }

    @Override
    public void add(Car item) {

    }

    @Override
    public List<Car> getList() {
        return null;
    }

    @Override
    public void delete(Car item) {

    }
}
