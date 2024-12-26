package com.fpoly.myspringbootapp.mapper;


import com.fpoly.myspringbootapp.dto.request.RoleRequest;
import com.fpoly.myspringbootapp.dto.request.UserRequest;
import com.fpoly.myspringbootapp.dto.response.RoleResponse;
import com.fpoly.myspringbootapp.dto.response.UserResponse;
import com.fpoly.myspringbootapp.entity.Role;
import com.fpoly.myspringbootapp.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mapping(target = "permissions",ignore = true)
    Role toRole(RoleRequest request);

    @Mapping(source = "permissions", target = "permissions")
    RoleResponse toRoleResponse(Role role);

    @Mapping(target = "permissions",ignore = true)
    void updateRole(@MappingTarget Role user, RoleRequest roleRequest);
}
