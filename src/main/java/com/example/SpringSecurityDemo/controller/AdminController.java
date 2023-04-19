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
@RequestMapping("/admin/")
public class AdminController
{
    @Autowired
    HttpSession session;

    @Autowired
    UserRepo userRepo;

    @GetMapping("/page1/")
    public String showPage1(Model model)
    {
        model.addAttribute("name", getLoggedInUser().getName());
        return "AdminPage1";
    }

    @GetMapping("/page2/")
    public String showPage2(Model model)
    {
        model.addAttribute("name", getLoggedInUser().getName());
        return "AdminPage2";
    }

    public User getLoggedInUser()
    {
        Long idUser = (Long) session.getAttribute("idUser");
        User userLoggedIn = userRepo.getReferenceById(idUser);
        return userLoggedIn;
    }
}
