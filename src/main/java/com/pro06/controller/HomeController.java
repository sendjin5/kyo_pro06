package com.pro06.controller;

import com.pro06.entity.Role;
import com.pro06.entity.User;
import com.pro06.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Log4j2
@Controller
public class HomeController {


    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String Home(Model model){
        return "index";
    }


    @GetMapping("/term")
    public String Term(Model model){
        return "/user/joinTerm";
    }


    @GetMapping("/login")
    public String Login(Model model){
        return "/user/login";
    }

    @GetMapping("/join1")
    public String JoinForm(Model model){
        return "/user/join1";
    }

    @PostMapping("/joinPro1")
    public String Join(Model model, User user){
        userService.userInsert(user);
        return "redirect:/";
    }

    @GetMapping("/error")
    public String error(Model model){
        return "/user/error";
    }

    @GetMapping("/Exindex")
    public String Exindex(Model model, Principal principal){
        User user = userService.getId(principal.getName());
        model.addAttribute("principal", principal);
        model.addAttribute("user", user);
        return "/user/Exindex";
    }

    @GetMapping("/out")
    public String out1(Principal principal, Model model){
        User user = userService.getId(principal.getName());
        user.setRole(Role.ADMIN);
        user.setAddr1("123번지");
        userService.userUpdate(user);
        return "redirect:/";
    }

}
