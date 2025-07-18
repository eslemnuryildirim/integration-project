package com.example.integrationproject.Model;
import jakarta.persistence.*;

import java.util.Map;

@Entity
@Table(name="users")
public class User {
@Id
private long id;
private String name;
private String email;
private String surname;

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }



    public Integer getAge() {
        return age;
    }

    public String getSurname() {
        return surname;
    }

    public String getDescription() {
        return description;
    }



    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    private Integer age;
    private String description;

    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
}
