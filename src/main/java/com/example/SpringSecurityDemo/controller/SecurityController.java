package com.example.SpringSecurityDemo.controller;

import com.example.SpringSecurityDemo.entity.User;
import com.example.SpringSecurityDemo.repository.UserRepo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController
{
    @Autowired
    HttpSession session;

    @Autowired
    UserRepo userRepo;

    @GetMapping("/default/")
    public String showDefaultPageAfterLogin(HttpServletRequest request, @CurrentSecurityContext(expression="authentication?.name") String username)
    {
        // Saving id of logged in user into session
        User userLoggedIn = userRepo.getByUsername(username);
        session.setAttribute("idUser", userLoggedIn.getId());

        if (request.isUserInRole("ROLE_ADMIN"))
        {
            return "redirect:/admin/page1/";
        }
        else if (request.isUserInRole("ROLE_EMP"))
        {
            return "redirect:/emp/page1/";
        }
        // similarly you can check for other designations like manager, analyst etc

        return "redirect:/";
    }
}
