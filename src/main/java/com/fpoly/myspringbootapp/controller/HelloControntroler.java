package com.fpoly.myspringbootapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloControntroler {

    @GetMapping
    public String showView(){

        return "home";
    }
}
