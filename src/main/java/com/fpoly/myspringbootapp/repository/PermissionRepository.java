package com.fpoly.myspringbootapp.repository;

import com.fpoly.myspringbootapp.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {


}
