package com.nhnacademy.jdbc.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
class DbUtilsTest {
    private static Connection connection = null;

    @BeforeAll
    static void setUp(){
        log.info("connection open()");
        connection = DbUtils.getConnection();
    }

    @Test
    @DisplayName("connected")
    void connectionTest(){
        Assertions.assertNotNull(connection);
    }

    @AfterAll
    static void release() throws SQLException {
        log.info("connection close()");
        connection.close();
    }

}