package com.fpoly.myspringbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.fpoly.myspringbootapp.entity", "com.fpoly.myspringbootapp"})
public class MySpringBootAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringBootAppApplication.class, args);
    }

}