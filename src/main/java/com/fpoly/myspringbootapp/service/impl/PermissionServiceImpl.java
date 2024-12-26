package com.fpoly.myspringbootapp.service.impl;

import com.fpoly.myspringbootapp.dto.request.PermissionRequest;
import com.fpoly.myspringbootapp.dto.response.PermissionResponse;
import com.fpoly.myspringbootapp.dto.response.RoleResponse;
import com.fpoly.myspringbootapp.entity.Permission;
import com.fpoly.myspringbootapp.exception.controller.AppException;
import com.fpoly.myspringbootapp.enums.ErrorCodeException;
import com.fpoly.myspringbootapp.mapper.PermissionMapper;
import com.fpoly.myspringbootapp.repository.PermissionRepository;
import com.fpoly.myspringbootapp.service.PermissionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class PermissionServiceImpl implements PermissionService {

    PermissionRepository repository;
    PermissionMapper mapper;

    @Override
    public List<PermissionResponse> getAll() {

        List<PermissionResponse> responses = repository.findAll()
                .stream().map(mapper::toPermissionResponse)
                .collect(Collectors.toList());

        return responses;
    }

    @Override
    public List<PermissionResponse> getByName(String name) {
        return null;
    }

    @Override
    public PermissionResponse getById(String name) {
        return null;
    }

    @Override
    public PermissionResponse add(PermissionRequest request) {
        Permission permission = mapper.toPermission(request);
        return mapper.toPermissionResponse(repository.save(permission));
    }

    @Override
    public String delete(String name) {
        Permission permission = repository.findById(name).orElseThrow(() -> new AppException(ErrorCodeException.PERMISSION_NOT_EXITS));
        repository.delete(permission);
        return ErrorCodeException.SUCCESS_CODE.getMessage();
    }

    @Override
    public PermissionResponse update(String name, RoleResponse request) {
        return null;
    }
}
