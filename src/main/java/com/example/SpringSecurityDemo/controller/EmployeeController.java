package com.example.SpringSecurityDemo.controller;

import com.example.SpringSecurityDemo.entity.User;
import com.example.SpringSecurityDemo.repository.UserRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emp/")
public class EmployeeController
{
    @Autowired
    HttpSession session;

    @Autowired
    UserRepo userRepo;

    @GetMapping("/page1/")
    public String showPage1(Model model)
    {
        model.addAttribute("name", getLoggedInUser().getName());
        return "EmployeePage1";
    }

    @GetMapping("/page2/")
    public String showPage2(Model model)
    {
        model.addAttribute("name", getLoggedInUser().getName());
        return "EmployeePage2";
    }

    public User getLoggedInUser()
    {
        // Getting id of logged in user from session
        Long idUser = (Long) session.getAttribute("idUser");
        User userLoggedIn = userRepo.getReferenceById(idUser);
        return userLoggedIn;
    }
}
