package com.fpoly.myspringbootapp.service.impl;

import com.fpoly.myspringbootapp.dto.request.UserRequest;
import com.fpoly.myspringbootapp.dto.response.UserResponse;
import com.fpoly.myspringbootapp.entity.UserEntity;
import com.fpoly.myspringbootapp.enums.Role;
import com.fpoly.myspringbootapp.exception.controller.AppException;
import com.fpoly.myspringbootapp.enums.ErrorCodeException;
import com.fpoly.myspringbootapp.mapper.UserMapper;
import com.fpoly.myspringbootapp.repository.PermissionRepository;
import com.fpoly.myspringbootapp.repository.RoleRepository;
import com.fpoly.myspringbootapp.repository.UserRepository;
import com.fpoly.myspringbootapp.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    UserMapper mapper;

    RoleRepository roleRepository;

    PermissionRepository permissionRepository;

    @Override
//    @PreAuthorize("hasRole('CREATE_POST')")
    @PreAuthorize("hasAuthority('CREATE_POST')")
    public List<UserResponse> getAllUser() {
        log.info("In method get User");
        List<UserResponse> users = userRepository.findAll().stream()
                .map(mapper::toUserResponse).collect(Collectors.toList());
        return users;
    }

    @Override
    public List<UserResponse> getUserByName(String name) {
        return null;
    }

    // Phân quuyền đúng Username và vai trò Admin mới có quyền truy cập
    @Override
//    @PostAuthorize("returnObject.username == authentication.name and hasRole('ADMIN')")
    @PostAuthorize("returnObject.username == authentication.name")
    public UserResponse getUserById(Integer id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() ->
                new AppException(ErrorCodeException.USER_NOT_EXITS));

        return mapper.toUserResponse(user);
    }


    @Override
    public UserResponse addUser(UserRequest request) {
        UserRequest value = request;
        UserEntity user = mapper.toUser(request);
//        if (request.getPassword() == null || request.getPassword().isEmpty()) {
//            throw new IllegalArgumentException("Password must not be null or empty");
//        }
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        if (request.getRole() == null || request.getRole().isEmpty()) {
            request.setRole(Role.USER.name());
        }

        return mapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public String deleteUser(Integer id) {
        return null;
    }

    @Override
    public UserResponse updateUser(Integer id, UserRequest request) {

        UserEntity user = userRepository.findById(id).orElseThrow(() -> new AppException(ErrorCodeException.USER_NOT_EXITS));
        mapper.updateUser(user, request);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        var roles = roleRepository.findAllById(request.getRoles());
        user.setRoles(new HashSet<>(roles));

        return mapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public UserResponse getMyInfo() {
        var context = SecurityContextHolder.getContext();
        String username = context.getAuthentication().getName();
        UserEntity user = userRepository.findByUsername(username).orElseThrow(() -> new AppException(ErrorCodeException.USER_NOT_EXITS));
        return mapper.toUserResponse(user);
    }
}
