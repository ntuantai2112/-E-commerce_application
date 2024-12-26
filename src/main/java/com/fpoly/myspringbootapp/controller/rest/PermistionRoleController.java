package com.fpoly.myspringbootapp.controller.rest;

import com.fpoly.myspringbootapp.dto.request.PermissionRequest;
import com.fpoly.myspringbootapp.dto.request.RoleRequest;
import com.fpoly.myspringbootapp.dto.response.ApiResponse;
import com.fpoly.myspringbootapp.dto.response.PermissionResponse;
import com.fpoly.myspringbootapp.dto.response.RoleResponse;
import com.fpoly.myspringbootapp.enums.ErrorCodeException;
import com.fpoly.myspringbootapp.service.PermissionService;
import com.fpoly.myspringbootapp.service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permission")
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermistionRoleController {


    PermissionService permissionService;

    @GetMapping("/get-all")
    public ResponseEntity<ApiResponse<List<PermissionResponse>>> getAll() {

        ApiResponse<List<PermissionResponse>> responses = new ApiResponse<>();
        responses.setResult(permissionService.getAll());
        responses.setMessage("Success fully!");
        responses.setCode(100);
        return ResponseEntity.ok(responses);

    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<PermissionResponse>> allRole(@RequestBody PermissionRequest request) {

        ApiResponse<PermissionResponse> responses = new ApiResponse<>();
        responses.setResult(permissionService.add(request));
        responses.setMessage("Success fully!");
        responses.setCode(100);
        return ResponseEntity.ok(responses);

    }


    @DeleteMapping("/delete/{name}")
    public ResponseEntity<ApiResponse<RoleResponse>> deleteRole(@PathVariable String name) {
        ApiResponse<RoleResponse> responses = new ApiResponse<>();
        permissionService.delete(name);
        responses.setMessage("Success fully!");
        responses.setCode(ErrorCodeException.SUCCESS_CODE.getCode());
        return ResponseEntity.ok(responses);
    }

}
