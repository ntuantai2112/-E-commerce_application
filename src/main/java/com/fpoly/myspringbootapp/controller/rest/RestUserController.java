package com.fpoly.myspringbootapp.controller.rest;

import com.fpoly.myspringbootapp.dto.request.UserRequest;
import com.fpoly.myspringbootapp.dto.response.ApiResponse;
import com.fpoly.myspringbootapp.dto.response.UserResponse;
import com.fpoly.myspringbootapp.entity.UserEntity;
import com.fpoly.myspringbootapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class RestUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get-all")
    public ResponseEntity<ApiResponse<List<UserResponse>>> getAllUser() {
        ApiResponse<List<UserResponse>> responses = new ApiResponse<>();
        responses.setResult(userService.getAllUser());
        responses.setMessage("Success fully!");
        responses.setCode(100);
        return ResponseEntity.ok(responses);

    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<UserResponse>> allUser(@RequestBody UserRequest userRequest) {

        ApiResponse<UserResponse> responses = new ApiResponse<>();
        responses.setResult(userService.addUser(userRequest));
        responses.setMessage("Success fully!");
        responses.setCode(100);
        return ResponseEntity.ok(responses);

    }


}
