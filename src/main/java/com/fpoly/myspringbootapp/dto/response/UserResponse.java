package com.fpoly.myspringbootapp.dto.response;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private Integer id;
    private String name;
    private String username;
    private String gender;
    private String image;
    private Integer age;
//    private String role;

    private Set<RoleResponse> roles;
}
