package org.example.controller;

import org.example.service.CarService;
import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AdminController {
    private final UserService userService;
    private final CarService carService;

    public AdminController(UserService userService, CarService carService) {
        this.userService = userService;
        this.carService = carService;
    }


    @GetMapping("")
    public String getCategoryList(
            Model model
    ) {
        model.addAttribute("userList", userService.getList());
        return "index";
    }
}
