package com.fpoly.myspringbootapp.repository;

import com.fpoly.myspringbootapp.dto.response.RoleResponse;
import com.fpoly.myspringbootapp.entity.Role;
import com.fpoly.myspringbootapp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,String> {

//    @Query("SELECT R FROM Role R JOIN ")
//    List<RoleResponse> getAll();
}
