package com.fpoly.myspringbootapp.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/category")
public class CategoryController {

    @GetMapping()
    public String showCategory(){
        return "/admin/category/index";
    }
}
