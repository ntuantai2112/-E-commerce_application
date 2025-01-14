package com.fpoly.myspringbootapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "user", schema = "finalweb10")
public class UserEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String username;
    private String password;
    private String gender;
    private String image;
    private Integer age;
    private Integer loginCounter;

    @ManyToMany()
    private Set<Role> roles;


}
