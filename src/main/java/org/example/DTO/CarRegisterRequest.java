package org.example.DTO;

import org.example.model.Users;

import java.sql.Date;

public class CarRegisterRequest {
    private int id;
    private String name;
    private double price;
    private String model;
    private String color;
    private Date createdDate;
    private Users user;
}
