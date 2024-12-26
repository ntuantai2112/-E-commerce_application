package com.fpoly.myspringbootapp.service;

import com.fpoly.myspringbootapp.dto.request.PermissionRequest;
import com.fpoly.myspringbootapp.dto.response.PermissionResponse;
import com.fpoly.myspringbootapp.dto.response.RoleResponse;

import java.util.List;

public interface PermissionService {

    List<PermissionResponse> getAll();


    List<PermissionResponse> getByName(String name);

    PermissionResponse getById(String name);

    PermissionResponse add(PermissionRequest request);

    String delete(String name);

    PermissionResponse update(String name, RoleResponse request);


}
