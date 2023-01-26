package org.example.controller;

import org.example.DTO.CarRegisterRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/car")
public class CarController {
    @PostMapping("/add")
public String addCar(Model model,
                     HttpRequestHandler httpRequestHandler,
                     @ModelAttribute CarRegisterRequest carRegisterRequest
                     ){
        return null;

    }
}
