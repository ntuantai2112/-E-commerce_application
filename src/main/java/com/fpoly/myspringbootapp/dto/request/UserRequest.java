package com.fpoly.myspringbootapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserRequest {

    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotBlank(message = "Username cannot be blank")
    private String username;
    @NotBlank(message = "Password cannot be blank")
    private String password;
    @NotBlank(message = "Gender cannot be blank")
    private String gender;

    private String image;
    private Integer age;

    private List<String> roles;
}
