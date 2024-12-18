package com.fpoly.myspringbootapp.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private Integer id;
    private String name;
    private String username;
    private String password;
    private String role;
    private String gender;
    private String image;
    private Integer age;
}
