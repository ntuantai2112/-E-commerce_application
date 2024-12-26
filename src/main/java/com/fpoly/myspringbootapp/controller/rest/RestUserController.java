package com.fpoly.myspringbootapp.controller.rest;

import com.fpoly.myspringbootapp.dto.request.UserRequest;
import com.fpoly.myspringbootapp.dto.response.ApiResponse;
import com.fpoly.myspringbootapp.dto.response.UserResponse;
import com.fpoly.myspringbootapp.enums.ErrorCodeException;
import com.fpoly.myspringbootapp.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RestUserController {


    UserService userService;

    @GetMapping("/get-all")
    public ResponseEntity<ApiResponse<List<UserResponse>>> getAllUser() {


        var authentication = SecurityContextHolder.getContext().getAuthentication();

        log.info("Username: {}", authentication.getName());
        authentication.getAuthorities().forEach(grantedAuthority -> log.info(grantedAuthority.getAuthority()));

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

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> updateUser(@PathVariable Integer id, @RequestBody UserRequest userRequest) {

        ApiResponse<UserResponse> responses = new ApiResponse<>();
        responses.setResult(userService.updateUser(id, userRequest));
        responses.setMessage("Success fully!");
        responses.setCode(100);
        return ResponseEntity.ok(responses);

    }


    @GetMapping("/get-user/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> getUserById(@PathVariable Integer id) {
        ApiResponse<UserResponse> responses = new ApiResponse<>();
        responses.setResult(userService.getUserById(id));
        responses.setMessage("Success fully!");
        responses.setCode(ErrorCodeException.SUCCESS_CODE.getCode());
        return ResponseEntity.ok(responses);

    }

    @GetMapping("/get-my-info")
    public ResponseEntity<ApiResponse<UserResponse>> getMyInfo() {
        ApiResponse<UserResponse> responses = new ApiResponse<>();
        responses.setResult(userService.getMyInfo());
        responses.setMessage("Success fully!");
        responses.setCode(ErrorCodeException.SUCCESS_CODE.getCode());
        return ResponseEntity.ok(responses);

    }


}
