package com.example.SpringSecurityDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/")
public class AdminController
{
    @GetMapping("/page1/")
    public String showPage1()
    {
        return "AdminPage1";
    }

    @GetMapping("/page2/")
    public String showPage2()
    {
        return "AdminPage2";
    }
}
