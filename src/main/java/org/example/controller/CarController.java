package org.example.controller;

import org.example.DAO.CarDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class CarController {

    private final CarDAO carDAO;

    public CarController(CarDAO carDAO){
        this.carDAO = carDAO;
    }

    @PostMapping("/cars")
    public String getCarList(Model model){
        model.addAttribute("carList",carDAO.getList());
        return "admin/car";
    }

    @GetMapping( "/user/cars")
    public String getButtonsValue(HttpServletRequest request, Model model){
        int userId = Integer.parseInt(request.getParameter("userId"));
        model.addAttribute("carList",carDAO.getList()
                .stream()
                .filter(car -> car.getId()==userId)
                .toList());
        return "admin/car";
    }


}
