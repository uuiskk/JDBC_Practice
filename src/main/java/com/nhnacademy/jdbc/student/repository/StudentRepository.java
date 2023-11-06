package com.nhnacademy.jdbc.student.repository;

import com.nhnacademy.jdbc.common.Page;
import com.nhnacademy.jdbc.student.domain.Student;

import java.sql.Connection;
import java.util.Optional;

public interface StudentRepository {

    int save(Connection connection, Student student);

    Optional<Student> findById(Connection connection, String id);

    int update(Connection connection, Student student);

    int deleteById(Connection connection, String id);

    //
    int deleteAll(Connection connection);

    //todo#1 totalCount 구현
    long totalCount(Connection connection);

    //todo#2 페이징 처리 구현
    Page<Student> findAll(Connection connection, int page, int pageSize);



}