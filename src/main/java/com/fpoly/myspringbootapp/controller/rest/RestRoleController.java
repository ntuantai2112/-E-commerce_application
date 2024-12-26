package com.fpoly.myspringbootapp.controller.rest;

import com.fpoly.myspringbootapp.dto.request.RoleRequest;
import com.fpoly.myspringbootapp.dto.request.UserRequest;
import com.fpoly.myspringbootapp.dto.response.ApiResponse;
import com.fpoly.myspringbootapp.dto.response.RoleResponse;
import com.fpoly.myspringbootapp.dto.response.UserResponse;
import com.fpoly.myspringbootapp.enums.ErrorCodeException;
import com.fpoly.myspringbootapp.service.RoleService;
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
@RequestMapping("/api/roles")
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RestRoleController {


    RoleService roleService;

    @GetMapping("/get-all")
    public ResponseEntity<ApiResponse<List<RoleResponse>>> getAll() {

        ApiResponse<List<RoleResponse>> responses = new ApiResponse<>();
        responses.setResult(roleService.getAll());
        responses.setMessage(ErrorCodeException.SUCCESS_CODE.getMessage());
        responses.setCode(ErrorCodeException.SUCCESS_CODE.getCode());
        return ResponseEntity.ok(responses);

    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<RoleResponse>> allRole(@RequestBody RoleRequest request) {

        ApiResponse<RoleResponse> responses = new ApiResponse<>();
        responses.setResult(roleService.add(request));
        responses.setMessage(ErrorCodeException.SUCCESS_CODE.getMessage());
        responses.setCode(ErrorCodeException.SUCCESS_CODE.getCode());
        return ResponseEntity.ok(responses);

    }


    @DeleteMapping("delete/{name}")
    public ResponseEntity<ApiResponse<RoleResponse>> deleteRole(@PathVariable String name) {
        ApiResponse<RoleResponse> responses = new ApiResponse<>();
        roleService.delete(name);
        responses.setMessage("Success fully!");
        responses.setCode(ErrorCodeException.SUCCESS_CODE.getCode());
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/update/{name}")
    public ResponseEntity<ApiResponse<RoleResponse>> updateUser(@PathVariable String name, @RequestBody RoleRequest roleRequest) {

        ApiResponse<RoleResponse> responses = new ApiResponse<>();
        responses.setResult(roleService.update(name, roleRequest));
        responses.setMessage(ErrorCodeException.SUCCESS_CODE.getMessage());
        responses.setCode(ErrorCodeException.SUCCESS_CODE.getCode());
        return ResponseEntity.ok(responses);

    }

}
