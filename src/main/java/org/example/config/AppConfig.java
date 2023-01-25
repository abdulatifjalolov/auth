package org.example.config;

import org.example.DAO.CarDAO;
import org.example.DAO.UserDAO;
import org.example.model.Users;
import org.example.service.CarService;
import org.example.service.UserService;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import org.example.model.Car;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class AppConfig {
    @Bean
    public SessionFactory sessionFactory() {
        return new org.hibernate.cfg.Configuration()
                .configure()
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Users.class)
                .buildSessionFactory();
    }
    @Bean
    public UserDAO userDAO(){
    return new UserDAO(sessionFactory());
    }
    @Bean
    public CarDAO carDAO(){
        return new CarDAO(sessionFactory());
    }
    @Bean
    public CarService carService(){
        return new CarService(carDAO(),userDAO());
    }
    @Bean
    public UserService userService(){
        return new UserService(carDAO(),userDAO());
    }
}
