package com.nhnacademy.jdbc.student.repository.impl;

import com.nhnacademy.jdbc.student.domain.Student;
import com.nhnacademy.jdbc.student.repository.StudentRepository;
import com.nhnacademy.jdbc.util.DbUtils;
import lombok.extern.slf4j.Slf4j;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Optional;

@Slf4j
public class PreparedStatementStudentRepository implements StudentRepository {

    @Override
    public int save(Student student){
        //todo#1 학생 등록
        String sql = String.format("insert into jdbc_students(id, name, gender, age) values('%s','%s','%s','%d')",
                student.getId(),
                student.getName(),
                student.getGender(),
                student.getAge()
        );
        log.debug("save:{}", sql);

        try(Connection connection = DbUtils.getConnection();
            Statement statement = connection.createStatement();
        ){
            int result = statement.executeUpdate(sql);
            log.debug("save:{}",result);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Student> findById(String id){
        //todo#2 학생 조회
        String sql = String.format("select * from jdbc_students where id='%s'", id);
        log.debug("findById:{}", sql);

        try(Connection connection = DbUtils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            ) {
            if (rs.next()) {
                Student student = new Student(rs.getString("id"),
                        rs.getString("name"),
                        Student.GENDER.valueOf(rs.getString("gender")),
                        rs.getInt("age"),
                        rs.getTimestamp("created_at").toLocalDateTime()
                );
                return Optional.of(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public int update(Student student){
        //todo#3 학생 수정 , name 수정
        String sql = String.format("update jdbc_student set name = '%s', gender = '%s', age = %d where id = '%s' ",
                student.getName(),
                student.getGender(),
                student.getAge(),
                student.getId()
        );
        log.debug("update:{}", sql);

        try(Connection connection = DbUtils.getConnection();
            Statement statement = connection.createStatement();
            ) {
            int result = statement.executeUpdate(sql);
            log.debug("result:{}",result);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteById(String id){
        //todo#4 학생 삭제
        String sql = String.format("delete from jdbc_students where id='%s'",id);
        try(Connection connection = DbUtils.getConnection();
            Statement statement = connection.createStatement();
        ) {
            int result = statement.executeUpdate(sql);
            log.debug("result:{}",result);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}