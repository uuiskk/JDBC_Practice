package com.nhnacademy.jdbc.student.repository;

import com.nhnacademy.jdbc.student.dto.StudentDto;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.ThrowingSupplier;

import java.sql.SQLException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    public static StudentRepository studentRepository;

    @BeforeAll
    static void setUp(){
        studentRepository = new StudentRepository();
    }

    @Test
    @DisplayName("save 10 students")
    void save() {
        Random random = new Random();
        for(int i=1; i<=10; i++){
            String id="marco" + i;
            String name="마르코" + i;
            StudentDto.GENDER gender = StudentDto.GENDER.M;
            int age = random.nextInt(50);
            StudentDto studentDto = new StudentDto(id,name,gender,age);

            Assertions.assertDoesNotThrow(()->{
                studentRepository.save(studentDto);
            });
        }
    }

}