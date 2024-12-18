package com.fpoly.myspringbootapp.service;

import com.fpoly.myspringbootapp.dto.request.UserRequest;
import com.fpoly.myspringbootapp.dto.response.UserResponse;
import com.fpoly.myspringbootapp.entity.UserEntity;

import java.util.List;

public interface UserService {

    List<UserResponse> getAllUser();


    List<UserResponse> getUserByName(String name);

    UserResponse getUserById(Integer id);

    UserResponse addUser(UserRequest request);

    String deleteUser(Integer id);

    UserResponse updateUser(Integer id,UserRequest request);

}
