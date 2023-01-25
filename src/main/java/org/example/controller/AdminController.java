package org.example.controller;

import org.example.DAO.CarDAO;
import org.example.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("admin/")
public class AdminController {
    private final UserDAO userDAO;
    private final CarDAO carDAO;

    public AdminController(UserDAO userDAO, CarDAO carDAO) {
        this.userDAO = userDAO;
        this.carDAO = carDAO;
    }

    @GetMapping("/user-list")
    public String getCategoryList(
            Model model
    ) {
        model.addAttribute("userList", userDAO.getList());
        return "users";
    }
}
