package com.fpoly.myspringbootapp.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "user", schema = "finalweb10")
public class UserEntity {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String username;
    private String password;
    private String role;
    private String gender;
    private String image;
    private Integer age;
    private Integer loginCounter;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "username", nullable = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = true)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "role", nullable = true)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "gender", nullable = true)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "image", nullable = true)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "age", nullable = true)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "login_counter", nullable = true)
    public Integer getLoginCounter() {
        return loginCounter;
    }

    public void setLoginCounter(Integer loginCounter) {
        this.loginCounter = loginCounter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(role, that.role) && Objects.equals(gender, that.gender) && Objects.equals(image, that.image) && Objects.equals(age, that.age) && Objects.equals(loginCounter, that.loginCounter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, username, password, role, gender, image, age, loginCounter);
    }
}
