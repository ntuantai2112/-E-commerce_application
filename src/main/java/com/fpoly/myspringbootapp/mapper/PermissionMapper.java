package com.fpoly.myspringbootapp.mapper;


import com.fpoly.myspringbootapp.dto.request.PermissionRequest;
import com.fpoly.myspringbootapp.dto.request.RoleRequest;
import com.fpoly.myspringbootapp.dto.response.PermissionResponse;
import com.fpoly.myspringbootapp.dto.response.RoleResponse;
import com.fpoly.myspringbootapp.entity.Permission;
import com.fpoly.myspringbootapp.entity.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {


    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
