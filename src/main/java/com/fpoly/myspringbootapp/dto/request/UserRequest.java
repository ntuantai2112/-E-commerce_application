package com.fpoly.myspringbootapp.dto.request;

import com.fpoly.myspringbootapp.validator.AgeConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserRequest {

    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotBlank(message = "USERNAME_NOT_NULL")
    @NotNull(message = "USERNAME_NOT_NULL")
    private String username;
    @NotBlank(message = "Password cannot be blank")
    private String password;
    @NotBlank(message = "Gender cannot be blank")
    private String gender;


    private String image;

    @AgeConstraint(min = 18, message = "INVALID_AGE")
    private Integer age;

    private List<String> roles;
}
