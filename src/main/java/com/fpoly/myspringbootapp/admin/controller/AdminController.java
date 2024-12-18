package com.fpoly.myspringbootapp.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class AdminController {

    @GetMapping("/admin")
    public String showViewAdminHome(){
        return  "/admin/index";
    }
}
