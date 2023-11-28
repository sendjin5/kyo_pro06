package com.pro06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

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

    @PostMapping("/loginPro")
    public String loginPro(Model model){

        return "redirect:/";
    }


    @GetMapping("/join")
    public String JoinForm(Model model){
        return "/user/join";
    }


    @PostMapping("/join")
    public String Join(Model model){

        return "redirect:/";
    }
}
