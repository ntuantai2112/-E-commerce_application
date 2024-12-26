package com.fpoly.myspringbootapp.service.impl;

import com.fpoly.myspringbootapp.dto.request.RoleRequest;
import com.fpoly.myspringbootapp.dto.response.RoleResponse;
import com.fpoly.myspringbootapp.entity.Role;
import com.fpoly.myspringbootapp.exception.controller.AppException;
import com.fpoly.myspringbootapp.enums.ErrorCodeException;
import com.fpoly.myspringbootapp.mapper.RoleMapper;
import com.fpoly.myspringbootapp.repository.PermissionRepository;
import com.fpoly.myspringbootapp.repository.RoleRepository;
import com.fpoly.myspringbootapp.service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoleServiceImpl implements RoleService {


    RoleRepository roleRepository;

    RoleMapper mapper;

    PermissionRepository permissionRepository;

    @Override
    public List<RoleResponse> getAll() {

        List<RoleResponse> responses = roleRepository.findAll()
                .stream().map(mapper::toRoleResponse)
                .collect(Collectors.toList());

        return responses;
    }

    @Override
    public List<RoleResponse> getByName(String name) {
        return null;
    }

    @Override
    public RoleResponse getById(String name) {
        return null;
    }

    @Override
    public RoleResponse add(RoleRequest request) {
        Role role = mapper.toRole(request);

        var permission = permissionRepository.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permission));
        return mapper.toRoleResponse(roleRepository.save(role));
    }

    @Override
    public String delete(String name) {
        Role role = roleRepository.findById(name).orElseThrow(() -> new AppException(ErrorCodeException.ROLE_NOT_EXITS));
        roleRepository.delete(role);
        return ErrorCodeException.SUCCESS_CODE.getMessage();
    }

    @Override
    public RoleResponse update(String name, RoleRequest request) {

        Role role = roleRepository.findById(name).orElseThrow(() -> new AppException(ErrorCodeException.ROLE_NOT_EXITS));
        var permission = permissionRepository.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permission));
        mapper.updateRole(role, request);

        return mapper.toRoleResponse(roleRepository.save(role));
    }
}
