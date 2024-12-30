package com.fpoly.myspringbootapp.repository;

import com.fpoly.myspringbootapp.entity.InvalidatedToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface InvalidedTokenRepository  extends JpaRepository<InvalidatedToken,String> {

    int deleteByExpiryTimeBefore(Date expiryTime);
}
