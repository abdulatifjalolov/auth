package org.example.service;

import org.example.DAO.CarDAO;
import org.example.DAO.UserDAO;

import java.util.List;

public class UserService implements BaseService{
    private  final CarDAO carDAO;
    private  final UserDAO userDAO;

    public UserService(CarDAO carDAO, UserDAO userDAO) {
        this.userDAO = userDAO;
        this.carDAO = carDAO;
    }
    @Override
    public Object getById(int id) {
        return null;
    }

    @Override
    public void add(Object item) {

    }

    @Override
    public List getList() {
        return null;
    }

    @Override
    public void delete(Object item) {

    }
}
