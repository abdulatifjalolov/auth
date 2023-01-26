package org.example.config;

import org.example.DAO.CarDAO;
import org.example.DAO.UserDAO;
import org.example.service.CarService;
import org.example.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class AppConfig {
//    @Bean
//    public SessionFactory sessionFactory() {
//        return new org.hibernate.cfg.Configuration()
//                .configure()
//                .addAnnotatedClass(Car.class)
//                .addAnnotatedClass(Users.class)
//                .buildSessionFactory();
//    }
    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        return sessionFactory;
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
