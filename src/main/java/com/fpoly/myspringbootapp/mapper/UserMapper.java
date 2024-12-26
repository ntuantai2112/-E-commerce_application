package com.fpoly.myspringbootapp.mapper;


import com.fpoly.myspringbootapp.dto.request.UserRequest;
import com.fpoly.myspringbootapp.dto.response.UserResponse;
import com.fpoly.myspringbootapp.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

     @Mapping(target = "roles",ignore = true)
     UserEntity toUser(UserRequest request);

     UserResponse toUserResponse(UserEntity userEntity);

    @Mapping(target = "roles",ignore = true)
    void updateUser(@MappingTarget UserEntity user, UserRequest userRequest);
}
