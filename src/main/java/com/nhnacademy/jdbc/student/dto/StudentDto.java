package com.nhnacademy.jdbc.student.dto;

import java.time.LocalDateTime;

public class StudentDto {

    public enum GENDER{
        M,F
    }

    private final String id;
    private final String name;
    private final GENDER gender;
    private final Integer age;
    private final LocalDateTime createdAt;

    public StudentDto(String id, String name, GENDER gender, Integer age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.createdAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public GENDER getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
