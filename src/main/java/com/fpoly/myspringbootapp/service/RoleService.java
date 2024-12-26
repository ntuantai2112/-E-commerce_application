package com.fpoly.myspringbootapp.service;

import com.fpoly.myspringbootapp.dto.request.RoleRequest;
import com.fpoly.myspringbootapp.dto.request.UserRequest;
import com.fpoly.myspringbootapp.dto.response.RoleResponse;
import com.fpoly.myspringbootapp.dto.response.UserResponse;

import java.util.List;

public interface RoleService {

    List<RoleResponse> getAll();


    List<RoleResponse> getByName(String name);

    RoleResponse getById(String name);

    RoleResponse add(RoleRequest request);

    String delete(String name);

    RoleResponse update(String name, RoleRequest request);


}
