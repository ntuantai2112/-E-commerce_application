package com.fpoly.myspringbootapp.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeUserController {

        @GetMapping("/user")
        public String showViewHome(){
        return  "user/index";
        }
}
