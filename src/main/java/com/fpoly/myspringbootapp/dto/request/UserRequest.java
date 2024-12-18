package com.fpoly.myspringbootapp.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserRequest {

    private String name;
    private String username;
    private String password;
    private String role;
    private String gender;
    private String image;
    private Integer age;
}
