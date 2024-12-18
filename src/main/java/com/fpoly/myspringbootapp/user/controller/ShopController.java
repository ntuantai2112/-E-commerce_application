package com.fpoly.myspringbootapp.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopController {

    @GetMapping("/shop")
    public String showViewShop(){

        return  "shop/index";
    }
}
