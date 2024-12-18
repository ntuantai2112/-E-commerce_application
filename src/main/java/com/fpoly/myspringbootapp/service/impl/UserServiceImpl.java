package com.fpoly.myspringbootapp.service.impl;

import com.fpoly.myspringbootapp.dto.request.UserRequest;
import com.fpoly.myspringbootapp.dto.response.UserResponse;
import com.fpoly.myspringbootapp.entity.UserEntity;
import com.fpoly.myspringbootapp.mapper.UserMapper;
import com.fpoly.myspringbootapp.repository.UserRepository;
import com.fpoly.myspringbootapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper mapper;

    @Override
    public List<UserResponse> getAllUser() {

//        List<UserResponse> users = userRepository.findAll().stream()
//                .map(mapper::toUserResponse).collect(Collectors.toList());

        List<UserResponse> responses = new ArrayList<>();
        for (UserEntity user : userRepository.findAll()) {
            responses.add(mapper.toUserResponse(user));
        }


        return responses;
    }

    @Override
    public List<UserResponse> getUserByName(String name) {
        return null;
    }

    @Override
    public UserResponse getUserById(Integer id) {

        return null;
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

        return mapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public String deleteUser(Integer id) {
        return null;
    }

    @Override
    public UserResponse updateUser(Integer id, UserRequest request) {
        return null;
    }
}
