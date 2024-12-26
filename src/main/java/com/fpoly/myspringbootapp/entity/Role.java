package com.fpoly.myspringbootapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role {

    @Id
    private String name;
    private String description;

    @ManyToMany
    private Set<Permission> permissions;

}
