package com.fpoly.myspringbootapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class InvalidatedToken {
    @Id
    private String id;
    private Date expiryTime;


}
