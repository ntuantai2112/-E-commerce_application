package com.fpoly.myspringbootapp.repository;

import com.fpoly.myspringbootapp.entity.UserEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {




    Optional<UserEntity> findByUsername(String username);
}
