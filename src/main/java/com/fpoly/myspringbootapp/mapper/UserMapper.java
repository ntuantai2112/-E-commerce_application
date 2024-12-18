package com.fpoly.myspringbootapp.mapper;


import com.fpoly.myspringbootapp.dto.request.UserRequest;
import com.fpoly.myspringbootapp.dto.response.UserResponse;
import com.fpoly.myspringbootapp.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {


     UserEntity toUser(UserRequest request);

    UserResponse toUserResponse(UserEntity userEntity);
}
